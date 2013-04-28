package games.util.command.generic;

import games.util.grid.Point2D;


/**
 * Interface that defines a command for moving a specific object from one position to another.
 * 
 * @author edwin
 *
 */
public interface MoveCommand<T> {

	/**
	 * @return the object where a move command will be performed. Never null.
	 */
	T getObject();

	/**
	 * @return The current location the object resides at. Can never be null.
	 */
	Point2D getCurrentLocation();

	/**
	 * @return the location after the move command has been performed via {@link #setNewLocation()} or returns the location where the object has to be moved to.
	 */
	Point2D getNewLocation();

	/**
	 * Set the new location of the object. Can be null when the object does not or no longer exist at the new location.
	 */
	void setNewLocation(Point2D newLocation);
}