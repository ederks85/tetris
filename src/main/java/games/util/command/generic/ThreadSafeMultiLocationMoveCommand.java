package games.util.command.generic;


import games.util.grid.Point2D;

import java.util.concurrent.atomic.AtomicReference;

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
		if (object == null) {
			throw new IllegalArgumentException("Object is null");
		}
		if (currentLocation == null) {
			throw new IllegalArgumentException("CurrentLocation is null");
		}
		if (newLocation == null) {
			throw new IllegalArgumentException("NewLocation is null");
		}

		this.object = object;
		this.currentLocations = new AtomicReference<>(currentLocation);
		this.newLocations = new AtomicReference<>(newLocation);
	}

	@Override
	public Point2D[] getCurrentLocation() {
		return this.currentLocations.get();
	}

	@Override
	public Point2D[] getNewLocation() {
		return this.newLocations.get();
	}

	@Override
	public T getObject() {
		return this.object;
	}
}