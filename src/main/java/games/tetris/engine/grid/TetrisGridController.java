package games.tetris.engine.grid;

import games.tetris.generic.command.MultiLocationMoveCommand;
import games.tetris.generic.command.SingleLocationMoveCommand;
import games.tetris.generic.grid.Dimension;
import games.tetris.generic.grid.GridController;
import games.tetris.generic.grid.GridFieldOccupiedException;
import games.tetris.generic.grid.GridOutOfBoundsException;
import games.tetris.generic.grid.Point2D;
import games.tetris.generic.grid.Virtual2DGrid;

/**
 * Class that will perform thread-safe atomic operations on a {@code Virtual2DBooleanGrid}. A {@code Virtual2DBooleanGrid} will be used to define which grid fields are being occupied. 
 * 
 * @author edwin
 *
 */
public class TetrisGridController implements GridController {

	private final Virtual2DGrid<Boolean> grid;

	public TetrisGridController() {
		this.grid = new TetrisGrid(10, 25); //TODO Make grid dimensions configurable in later version
	}

	/**
	 * {@inheritDoc} This method is synchronized so that the move is an atomic operation when used by multiple threads. The controller expects a current and new location to be available in the 
	 * move command. This way it is able to empty the old location and fill the new location. When the move is successful, the method returns and the move command is the evidence that the grid 
	 * is in synch with the object where the command is being performed for.
	 */
	@Override
	public synchronized <T> void moveObject(SingleLocationMoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException {
		if (moveCommand.getNewLocation() == null || moveCommand.getNewLocation() == null) {
			throw new IllegalArgumentException("Move Command or it's new location is null");
		}

		if (isFieldOccupied(moveCommand.getNewLocation())) {
			throw new GridFieldOccupiedException("Grid field (x=" + moveCommand.getNewLocation().getX() + ",y=" + moveCommand.getNewLocation().getY() + ") is already occupied");
		} else {
			// First perform the actual move
			this.grid.setObjectAtPosition(Boolean.TRUE, moveCommand.getNewLocation().getX(), moveCommand.getNewLocation().getY());

			// If the grid hasn't complained about the move, the move was successful and we can clear the old location if the object was already present
			if (moveCommand.getCurrentLocation() != null) {
				this.grid.setObjectAtPosition(Boolean.FALSE, moveCommand.getCurrentLocation().getX(), moveCommand.getCurrentLocation().getY());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see #moveObject(SingleLocationMoveCommand)
	 */
	@Override
	public synchronized <T> void moveObject(MultiLocationMoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException {
		if (moveCommand.getNewLocation() == null || moveCommand.getNewLocation() == null) {
			throw new IllegalArgumentException("Move Command or it's new locations are null");
		}

		if (moveCommand.getCurrentLocation() != null) {
			// The object has positions that need to be moved on the grid. For take the object from the grid by clearing it's current location
			for (Point2D currentLocation : moveCommand.getCurrentLocation()) {
				this.grid.setObjectAtPosition(Boolean.FALSE, currentLocation.getX(), currentLocation.getY());
			}

			try {
				for (Point2D newLocation : moveCommand.getNewLocation()) {
					if (isFieldOccupied(newLocation)) {
						throw new GridFieldOccupiedException(
								"Cannot move object because Grid field (x=" + newLocation.getX() + ",y=" + newLocation.getY() + ") is already occupied");
					}
				}

				// No exceptions occurred so we can safely place the object at it's new position
				for (Point2D newLocation : moveCommand.getNewLocation()) {
					this.grid.setObjectAtPosition(Boolean.TRUE, newLocation.getX(), newLocation.getY());
				}
			} catch (GridFieldOccupiedException | GridOutOfBoundsException e) {
				// An exception has occurred during the checks if the move is possible. Place the object back at it's current locations.
				for (Point2D currentLocation : moveCommand.getCurrentLocation()) {
					this.grid.setObjectAtPosition(Boolean.TRUE, currentLocation.getX(), currentLocation.getY());
				}

				// Now the grid is back in synch again. Now propagate exception to let caller know why the move failed
				throw e;
			}
		} else {
			// The object's locations are new on the grid so try to place them in the desired position and throw an exception when this is not possible
			for (Point2D newLocation : moveCommand.getNewLocation()) {
				if (isFieldOccupied(newLocation)) {
					throw new GridFieldOccupiedException("Cannot place object because Grid field (x=" + newLocation.getX() + ",y=" + newLocation.getY() + ") is already occupied");
				}
			}

			// All new locations are clear since no exceptions have occurred in the validation
			for (Point2D newLocation : moveCommand.getNewLocation()) {
				this.grid.setObjectAtPosition(Boolean.TRUE, newLocation.getX(), newLocation.getY());
			}
		}
	}

	private boolean isFieldOccupied(Point2D location) throws GridOutOfBoundsException {
		if (location == null) {
			throw new IllegalArgumentException("Location is null");
		}
		return this.grid.getObjectAtPosition(location.getX(), location.getY());
	}

	public Dimension getGridDimensions() {
		return this.grid.getGridDimensions();
	}
}