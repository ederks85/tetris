package games.tetris.engine.ai.task;

import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.object.TetrisObject;
import games.tetris.engine.object.TetrisObjectFactory;
import games.util.command.generic.ThreadSafeMultiLocationMoveCommand;
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

			final Point2D[] currentPositions = this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPositions();
			final Point2D[] newPositions;
			if (currentPositions == null) {
				newPositions = new Point2D[]{new Point2D(5, 0), new Point2D(5, 1), new Point2D(6, 1), new Point2D(7, 1)};
			} else {
				newPositions = new Point2D[currentPositions.length];

				for (int i=0; i < currentPositions.length; i++) {
					newPositions[i] = new Point2D(currentPositions[i].getX(), currentPositions[i].getY() +1);
				}
			}

			try {
				this.tetrisAI.scheduleTetrisMoveCommand(new ThreadSafeMultiLocationMoveCommand<TetrisObject>(currentObject, this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPositions(), newPositions));
			} catch (Exception e) {
				System.out.println("Game should end here...");
				this.tetrisAI.stop();
				e.printStackTrace();
			}
		}
	}
}
