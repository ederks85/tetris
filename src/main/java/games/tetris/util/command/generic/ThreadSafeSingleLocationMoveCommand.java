package games.tetris.util.command.generic;

import games.tetris.util.grid.Point2D;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Edwin on 29-7-2016.
 */
public class ThreadSafeSingleLocationMoveCommand<T> implements SingleLocationMoveCommand<T> {

    private final T object;

    private final AtomicReference<Point2D> currentLocation;
    private final AtomicReference<Point2D> newLocation;


    public ThreadSafeSingleLocationMoveCommand(final T object, final Point2D currentLocation, final Point2D newLocation) {
        if (object == null) {
            throw new IllegalArgumentException("Object is null");
        }

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

    @Override
    public T getObject() {
        return this.object;
    }
}