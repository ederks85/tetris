package games.tetris.engine.ai.task;

import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.object.TetrisObject;
import games.tetris.engine.object.TetrisObjectFactory;
import games.util.command.generic.ThreadSafeMoveCommand;
import games.util.grid.Point2D;

import java.util.TimerTask;

import org.apache.commons.lang.Validate;

/**
 * Implementation for basic move task that is scheduled by a {@code TetrisAI}. 
 * 
 * @author edwin
 *
 */
public class TetrisAIMoveTask extends TimerTask {

	private final TetrisAI tetrisAI;

	public TetrisAIMoveTask(TetrisAI tetrisAI) {
		Validate.notNull(tetrisAI, "TetrisAI is null.");
		this.tetrisAI = tetrisAI;
	}

	@Override
	public void run() {
		synchronized (this.tetrisAI.getTetrisGameState()) {
			final TetrisObject currentObject;
			if (this.tetrisAI.getTetrisGameState().getCurrentTetrisObject() == null) {
				currentObject = TetrisObjectFactory.getRandomTetrisObject();
			} else {
				currentObject = this.tetrisAI.getTetrisGameState().getCurrentTetrisObject();
			}

			final Point2D currentPosition = this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPosition();
			final Point2D newPosition;
			if (currentPosition == null) {
				newPosition = new Point2D(5, 0);
			} else {
				newPosition = new Point2D(currentPosition.getX(), (currentPosition.getY() + 1));
			}

			try {
				this.tetrisAI.scheduleTetrisMoveCommand(new ThreadSafeMoveCommand<TetrisObject>(currentObject, this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPosition(), newPosition));
			} catch (Exception e) {
				System.out.println("Game should end here...");
				this.tetrisAI.stop();
				e.printStackTrace();
			}
		}
	}
}
