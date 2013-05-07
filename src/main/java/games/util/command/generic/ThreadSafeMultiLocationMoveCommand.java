package games.util.command.generic;


import java.util.concurrent.atomic.AtomicReference;

import games.util.grid.Point2D;

import org.apache.commons.lang.Validate;

/**
 * Object that performs a move command that can be shared by multiple threads. This class expects the composite object to be available on multiple locations.
 * 
 * @author edwin
 *
 */
public class ThreadSafeMultiLocationMoveCommand<T> implements MultiLocationMoveCommand<T> {

	private final T object;

	private final AtomicReference<Point2D[]> currentLocations;
	private final AtomicReference<Point2D[]> newLocations;


	public ThreadSafeMultiLocationMoveCommand(final T object, final Point2D[] currentLocation, final Point2D[] newLocation) {
		Validate.notNull(object, "Object is null");

		this.object = object;
		this.currentLocations = new AtomicReference<>(currentLocation);
		this.newLocations = new AtomicReference<>(newLocation);
	}

	/**
	 * Create a move command for an object where the new locations are yet unknown.
	 */
	public ThreadSafeMultiLocationMoveCommand(final T object, final Point2D[] currentLocation) {
		this(object, currentLocation, null);
	}

	/**
	 * Create a move command for an object where the current and new location are yet unknown.
	 */
	public ThreadSafeMultiLocationMoveCommand(final T object) {
		this(object, null, null);
	}

	@Override
	public T getObject() {
		return this.object;
	}

	@Override
	public Point2D[] getCurrentLocation() {
		return this.currentLocations.get();
	}

	@Override
	public void setNewLocation(Point2D[] newLocation) {
		this.newLocations.set(newLocation);
	}

	@Override
	public Point2D[] getNewLocation() {
		return this.newLocations.get();
	}
}