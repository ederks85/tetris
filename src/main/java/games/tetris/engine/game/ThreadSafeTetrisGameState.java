package games.tetris.engine.game;

import java.util.concurrent.atomic.AtomicReference;

import games.tetris.engine.object.TetrisObject;
import games.util.grid.Point2D;

/**
 * Default implementation of {@code TetrisGameState} that can safely be shared between components.
 * 
 * @author edwin
 *
 */
public class ThreadSafeTetrisGameState implements TetrisGameState {

	private final AtomicReference<TetrisObject> currentTetrisObject;
	private final AtomicReference<Point2D> currentTetrisObjectLocation;

	public ThreadSafeTetrisGameState() {
		this.currentTetrisObject = new AtomicReference<>();
		this.currentTetrisObjectLocation = new AtomicReference<>();
	}

	@Override
	public TetrisObject getCurrentTetrisObject() {
		return this.currentTetrisObject.get();
	}

	public void setCurrentTetrisObject(TetrisObject newTetrisObject) {
		this.currentTetrisObject.set(newTetrisObject);
	}

	@Override
	public Point2D getCurrentTetrisObjectPosition() {
		return this.currentTetrisObjectLocation.get();
	}

	@Override
	public void setCurrentTetrisObjectPosition(Point2D newLocation) {
		this.currentTetrisObjectLocation.set(newLocation);
	}
}