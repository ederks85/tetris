package games.tetris.engine.ai;

import games.tetris.engine.ai.task.TetrisAIMoveTask;
import games.tetris.engine.game.AbstractTetrisGameSubscriber;
import games.tetris.engine.object.TetrisObject;
import games.tetris.util.command.generic.MultiLocationMoveCommand;
import games.tetris.util.grid.GridFieldOccupiedException;
import games.tetris.util.grid.GridOutOfBoundsException;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * The AI that schedules timed move commands on the engine.
 * 
 * @author edwin
 *
 */
public class TetrisAI extends AbstractTetrisGameSubscriber {

	private final int interval; //TODO Key part of speed difficulty.
	private final Timer timer;

	/**
	 * Create the object that schedules move commands on the Tetris engine at a desired interval.
	 */
	public TetrisAI() {
		this.interval = 200; //(milliseconds) TODO make interval configurable
		this.timer = new Timer("TetrisAI");
	}

	/**
	 * Start schedule move commands.
	 */
	public void start() {
		this.timer.scheduleAtFixedRate(new TetrisAIMoveTask(this), 0, this.interval);
	}

	/**
	 * Stop scheduling move commands. After calling this method, the instance of this class is dead.
	 */
	public void stop() {
		this.timer.cancel();
	}

	@Override
	public void scheduleTetrisMoveCommand(MultiLocationMoveCommand<TetrisObject> moveCommand) {
		try {
			final Future<MultiLocationMoveCommand<TetrisObject>> executedCommand = getCommandProcessor().performMoveAction(moveCommand);
			executedCommand.get();

			// If no exception has occurred, we can update the game state with the new location of current object
			getTetrisGameState().setCurrentTetrisObject(moveCommand.getObject());
			getTetrisGameState().setCurrentTetrisObjectPosition(moveCommand.getNewLocation());
		} catch (Exception e) {
			if (e instanceof ExecutionException && e.getCause() instanceof GridOutOfBoundsException) {
				// Object could not be moved to new location because it has reached a boundary of the grid. Start a new round.
				e.printStackTrace();
				getTetrisGameState().setCurrentTetrisObject(null);
				getTetrisGameState().setCurrentTetrisObjectPosition(null);
			} else if (e instanceof ExecutionException && e.getCause() instanceof GridFieldOccupiedException) {
				// If an existing object is being moved to an already occupied field, leave the object at it's current position and start a new round.
				if (getTetrisGameState().getCurrentTetrisObject() != null) {
					e.printStackTrace();
					getTetrisGameState().setCurrentTetrisObject(null);
					getTetrisGameState().setCurrentTetrisObjectPosition(null);
				} else {
					// A new object is tried to be placed on it's first position in the game but it is blocked by another object. In Tetris, this means game over.
					e.printStackTrace();
					stop();
					throw new IllegalStateException("Game Over"); //TODO Create nice handling of this scenario in next version
				}
			} else {
				e.printStackTrace();
				stop();
				throw new IllegalStateException("Game Over due to unexpected exception");
			}
		}
	}
}