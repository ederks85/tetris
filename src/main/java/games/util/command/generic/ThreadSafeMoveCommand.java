package games.util.command.generic;


import java.util.concurrent.atomic.AtomicReference;

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

	private final AtomicReference<Point2D> currentLocation;
	private final AtomicReference<Point2D> newLocation;


	public ThreadSafeMoveCommand(final T object, final Point2D currentLocation, final Point2D newLocation) {
		Validate.notNull(object, "Object is null");

		this.object = object;
		this.currentLocation = new AtomicReference<>(currentLocation);
		this.newLocation = new AtomicReference<>(newLocation);
	}

	/**
	 * Create a move command for an object where the new location is yet unknown.
	 */
	public ThreadSafeMoveCommand(final T object, final Point2D currentLocation) {
		this(object, currentLocation, null);
	}

	/**
	 * Create a move command for an object where the current and new location are yet unknown.
	 */
	public ThreadSafeMoveCommand(final T object) {
		this(object, null, null);
	}

	@Override
	public T getObject() {
		return this.object;
	}

	@Override
	public Point2D getCurrentLocation() {
		return this.currentLocation.get();
	}

	@Override
	public void setNewLocation(Point2D newLocation) {
		this.newLocation.set(newLocation);
	}

	@Override
	public Point2D getNewLocation() {
		return this.newLocation.get();
	}
}