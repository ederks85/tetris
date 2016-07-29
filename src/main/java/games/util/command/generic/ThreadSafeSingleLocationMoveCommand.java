package games.util.command.generic;

import games.util.grid.Point2D;
import lombok.Getter;
import lombok.NonNull;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Edwin on 29-7-2016.
 */
public class ThreadSafeSingleLocationMoveCommand<T> implements SingleLocationMoveCommand<T> {

    @Getter
    private final T object;

    private final AtomicReference<Point2D> currentLocation;
    private final AtomicReference<Point2D> newLocation;


    public ThreadSafeSingleLocationMoveCommand(@NonNull final T object, final Point2D currentLocation, final Point2D newLocation) {
        this.object = object;
        this.currentLocation = new AtomicReference<>(currentLocation);
        this.newLocation = new AtomicReference<>(newLocation);
    }

    /**
     * Create a move command for an object where the new locations are yet unknown.
     */
    public ThreadSafeSingleLocationMoveCommand(final T object, final Point2D currentLocation) {
        this(object, currentLocation, null);
    }

    @Override
    public Point2D getCurrentLocation() {
        return this.currentLocation.get();
    }

    @Override
    public Point2D getNewLocation() {
        return this.newLocation.get();
    }
}