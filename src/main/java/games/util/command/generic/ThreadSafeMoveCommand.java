package games.util.command.generic;


import games.util.grid.Point2D;

import org.apache.commons.lang.Validate;

/**
 * Object that performs a move command that can be shared by multiple threads.
 * 
 * @author edwin
 *
 */
public class ThreadSafeMoveCommand<T> implements MoveCommand<T> {

	private final T object;

	private final Point2D currentLocation;
	private Point2D newLocation;

	public ThreadSafeMoveCommand(final T object, final Point2D currentLocation, final Point2D newLocation) {
		this(object, currentLocation);
		Validate.notNull(newLocation, "New location is null");

		this.newLocation = newLocation;
	}

	/**
	 * Create a move command for an object where the new location is yet unknown.
	 * 
	 * @param object
	 * @param currentLocation
	 */
	public ThreadSafeMoveCommand(final T object, final Point2D currentLocation) {
		Validate.notNull(object, "Object is null");
		Validate.notNull(currentLocation, "Current location is null");

		this.object = object;
		this.currentLocation = currentLocation;
	}

	@Override
	public T getObject() {
		return this.object;
	}

	@Override
	public Point2D getCurrentLocation() {
		return this.currentLocation;
	}

	@Override
	public synchronized void setNewLocation(Point2D newLocation) {
		this.newLocation = newLocation;
	}

	@Override
	public synchronized Point2D getNewLocation() {
		return this.newLocation;
	}
}