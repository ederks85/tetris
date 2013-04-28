package games.util.grid;

import games.util.command.generic.MoveCommand;

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
	<T> void moveObject(MoveCommand<T> moveCommand) throws GridOutOfBoundsException, GridFieldOccupiedException;
}