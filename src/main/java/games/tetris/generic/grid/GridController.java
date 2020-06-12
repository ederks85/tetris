package games.tetris.generic.grid;

import games.tetris.generic.command.MultiLocationMoveCommand;
import games.tetris.generic.command.SingleLocationMoveCommand;

/**
 * Interface that defines the atomic operations that can be performed on a grid.
 * 
 * @author edwin
 *
 */
public interface GridController {

	/**
	 * Perform a move for an object on the grid. The {@code MoveCommand} specifies which object has to move where.
	 * 
	 * @param moveCommand The command containing the details
	 * 
	 * @throws GridOutOfBoundsException when the object is being moved outside the boundaries of the grid.
	 * @throws GridFieldOccupiedException when the object is being moved to a location that is already occupied.
	 */
	<T> void moveObject(SingleLocationMoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException;

	/**
	 * Perform a move for a composite object on the grid. The {@code MoveCommand} specifies which part of the object has to move where.
	 * 
	 * @param moveCommand The command containing the details
	 * 
	 * @throws GridOutOfBoundsException when a part of the object is being moved outside the boundaries of the grid.
	 * @throws GridFieldOccupiedException when a part of the object is being moved to a location that is already occupied.
	 */
	<T> void moveObject(MultiLocationMoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException;
}