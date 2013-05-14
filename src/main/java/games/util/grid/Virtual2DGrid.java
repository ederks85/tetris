package games.util.grid;

import games.util.grid.Dimension;

/**
 * Interface for classes that represents a 2D grid in memory.
 *
 * @author edwin
 *
 * @param <T> The type object that can be placed in the grid locations. 
 */
public interface Virtual2DGrid<T> {

	/**
	 * Place the object at the given position. This will override any current object at that position. A {@code null} value will clear the grid location.
	 * 
	 * @param object	The object that is to be placed on the grid
	 * @param x			The x location
	 * @param y			The y location
	 * 
	 * @throws GridOutOfBoundsException when the object is placed outside the grid boundaries.
	 */
	void setObjectAtPosition(T object, int x, int y) throws GridOutOfBoundsException;

	/**
	 * Get the current object at the given location.
	 * 
	 * @param x			The x location
	 * @param y			The y location
	 * 
	 * @throws GridOutOfBoundsException when the coordinates exceed the grid's boundaries.
	 * 
	 * @return when there is no object found, {@code null} will be returned or the found object otherwise.
	 */
	T getObjectAtPosition(int x, int y) throws GridOutOfBoundsException;

	/**
	 * @return A {@code Dimension} object that contains the grid's width and height.
	 */
	Dimension getGridDimensions();
}