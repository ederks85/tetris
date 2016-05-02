package games.tetris.engine.ai.task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import lombok.NonNull;
import org.apache.commons.lang3.Validate;

import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.object.TetrisObject;
import games.tetris.engine.object.TetrisObjectFactory;
import games.util.command.generic.ThreadSafeMultiLocationMoveCommand;
import games.util.grid.Dimension;
import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Point2D;

/**
 * Implementation for basic move task that is scheduled by a {@code TetrisAI}. 
 * 
 * @author edwin
 *
 */
public class TetrisAIMoveTask extends TimerTask {

	private final TetrisAI tetrisAI;

	public TetrisAIMoveTask(@NonNull TetrisAI tetrisAI) {
		this.tetrisAI = tetrisAI;
	}

	@Override
	public void run() {
		synchronized (this.tetrisAI.getTetrisGameState()) { // Arrange exclusive access to the game state so that it can not be modified by other components (threads) until the current task has been completed

			final TetrisObject currentObject;
			if (this.tetrisAI.getTetrisGameState().getCurrentTetrisObject() == null) {
				currentObject = TetrisObjectFactory.getRandomTetrisObject();
			} else {
				currentObject = this.tetrisAI.getTetrisGameState().getCurrentTetrisObject();
			}

			final Point2D[] currentPositions = this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPositions();

			if (currentPositions == null) { // The object is not yet place on the grid. Move it on the grid in steps.
				Point2D[] newPositions;
				Point2D[] filteredNewPositions;

				final ObjectPositionPreserver preserver = new ObjectPositionPreserver(createCurrentObjectInitialPositions(currentObject));

				do { //FIXME simulate the same interval as the timer itself
					newPositions = preserver.calculateNextPositions();
					filteredNewPositions = filterInvalidPositions(newPositions);

					final ThreadSafeMultiLocationMoveCommand<TetrisObject> moveCommand = new ThreadSafeMultiLocationMoveCommand<>(currentObject, this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPositions(), filteredNewPositions);
					this.tetrisAI.scheduleTetrisMoveCommand(moveCommand);
				}
				while (!(newPositions.length == filteredNewPositions.length));
			} else {
				final Point2D[] newPositions = new Point2D[currentPositions.length];

				for (int i=0; i < currentPositions.length; i++) {
					newPositions[i] = new Point2D(currentPositions[i].getX(), currentPositions[i].getY() +1);
				}

				final ThreadSafeMultiLocationMoveCommand<TetrisObject> moveCommand = new ThreadSafeMultiLocationMoveCommand<>(currentObject, this.tetrisAI.getTetrisGameState().getCurrentTetrisObjectPositions(), newPositions);
				this.tetrisAI.scheduleTetrisMoveCommand(moveCommand);
			}
		}
	}

	private Point2D[] createCurrentObjectInitialPositions(@NonNull final TetrisObject currentObject) {
		Point2D[] initialPositions = new Point2D[currentObject.getNumberOfPositions()];
		int initialPositionCounter = 0;

		final Dimension currentObjectDimensions = currentObject.getDimensions();

		final int initialXPosition = 5;
		final int initialYPosition = -(currentObjectDimensions.getHeight() - 1);

		for (int i = 0; i < currentObjectDimensions.getWidth(); i++) {
			for (int j = 0; j < currentObjectDimensions.getHeight(); j++) {
				try {
					if (currentObject.isPositionOccupied(i, j)) {
						initialPositions[initialPositionCounter] = new Point2D(initialXPosition + i, initialYPosition + j);
						initialPositionCounter++;
					}
				} catch (GridOutOfBoundsException e) {
					e.printStackTrace();
					throw new IllegalStateException("Exception while determining initial position of TetrisObject on the grid.", e);
				}
			}
		}

		return initialPositions;
	}

	private static Point2D[] filterInvalidPositions(@NonNull final Point2D[] positions) {
		List<Point2D> temp = new ArrayList<>();

		for (Point2D position : positions) {
			if (position.getX() >= 0 && position.getY() >= 0) {
				temp.add(position);
			}
		}

		Point2D[] filteredPositions = new Point2D[temp.size()];
		return temp.toArray(filteredPositions);
	}

	private static final class ObjectPositionPreserver {

		private Point2D[] preservedPositions;

		ObjectPositionPreserver(@NonNull final Point2D[] preservedPositions) {
			this.preservedPositions = preservedPositions;
		}

		Point2D[] calculateNextPositions() {
			final Point2D[] calculatedPositions = new Point2D[this.preservedPositions.length];

			for (int i=0; i < this.preservedPositions.length; i++) {
				calculatedPositions[i] = new Point2D(this.preservedPositions[i].getX(), this.preservedPositions[i].getY() + 1);
			}

			this.preservedPositions = calculatedPositions;
			return this.preservedPositions;
		}
	}
}
