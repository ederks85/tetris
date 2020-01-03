package games.util.command.generic;


import games.util.grid.Point2D;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Object that performs a move command that can be shared by multiple threads. This class expects the composite object to be available on multiple locations.
 * 
 * @author edwin
 *
 */
public class ThreadSafeMultiLocationMoveCommand<T> implements MultiLocationMoveCommand<T> {

	@Getter
	private final T object;

	private final AtomicReference<Point2D[]> currentLocations;
	private final AtomicReference<Point2D[]> newLocations;


	public ThreadSafeMultiLocationMoveCommand(@NonNull final T object, @NonNull final Point2D[] currentLocation, @NonNull final Point2D[] newLocation) {
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
}