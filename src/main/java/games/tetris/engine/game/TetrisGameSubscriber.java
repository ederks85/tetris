package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;
import games.tetris.util.command.generic.MultiLocationMoveCommand;

/**
 * Interface for the methods that are needed for a component to schedule commands on the Tetris engine and get notified of the result.
 * 
 * @author edwin
 *
 * @param T The type of {@code TetrisObject} game object that is being used.
 */
public interface TetrisGameSubscriber {

	/**
	 * Get the game state that can be read and/or modified by the subscriber.
	 * 
	 * @return The game state or null when state is yet unknown.
	 */
	TetrisGameState getTetrisGameState();

	/**
	 * Schedule a move command on the Tetris Engine. The {@code MoveCommand} will likely contain the object returned by {@link TetrisGameState#getCurrentTetrisObject()} but 
	 * this can change in later versions of the game.
	 * 
	 * @param MoveCommand The command that is to be executed by the Tetris engine.
	 */
	void scheduleTetrisMoveCommand(MultiLocationMoveCommand<TetrisObject> moveCommand);
}