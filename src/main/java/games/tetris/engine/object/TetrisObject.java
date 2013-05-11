package games.tetris.engine.object;

import games.util.grid.GridOutOfBoundsException;

import java.awt.Dimension;

/**
 * Interface for an object that contains the data to represent a Tetris object.
 * 
 * @author edwin
 *
 */
public interface TetrisObject {

	/**
	 * Since the {@link #getDimensions()} method returns a {@code Dimension} as a square and not all object occupy all the positions 
	 * in the square, this method can be used to determine how the object is formed.
	 * 
	 * @param x	The x position.
	 * @param y The y position.
	 * @return An occupied position returns {@link Boolean#TRUE}, in any other case {@link Boolean#FALSE}.
	 * 
	 * @throws GridOutOfBoundsException when checking outside of the dimensions.
	 */
	Boolean isPositionOccupied(int x, int y) throws GridOutOfBoundsException;

	/**
	 * Get the dimensions of the {@code TetrisObject}.
	 * 
	 * @return	The dimensions of the object. Can never be null.
	 */
	Dimension getDimensions();

	/**
	 * @return The number of positions that the object contains.
	 */
	int getNumberOfPositions();
}