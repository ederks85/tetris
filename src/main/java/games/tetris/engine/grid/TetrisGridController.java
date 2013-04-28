package games.tetris.engine.grid;

import org.apache.commons.lang.Validate;

import games.util.command.generic.MoveCommand;
import games.util.grid.GridController;
import games.util.grid.GridFieldOccupiedException;
import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Virtual2DGrid;

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
	public synchronized <T> void moveObject(MoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException {
		Validate.notNull(moveCommand, "Move Command is null");
		Validate.notNull(moveCommand.getNewLocation(), "Move Command's new location is null");

		Boolean occupied = this.grid.getObjectAtPosition(moveCommand.getNewLocation().getX(), moveCommand.getNewLocation().getY());

		if (occupied) {
			throw new GridFieldOccupiedException("Grid field (x=" + moveCommand.getNewLocation().getX() + ",y=" + moveCommand.getNewLocation().getY() + ") is already occupied");
		} else {
			// First perform the actual move
			this.grid.setObjectAtPosition(Boolean.TRUE, moveCommand.getNewLocation().getX(), moveCommand.getNewLocation().getY());
			// If the grid hasn't complained about the move, the move was succesful and we can clear the old location
			this.grid.setObjectAtPosition(Boolean.FALSE, moveCommand.getCurrentLocation().getX(), moveCommand.getCurrentLocation().getY());
		}
	}
}