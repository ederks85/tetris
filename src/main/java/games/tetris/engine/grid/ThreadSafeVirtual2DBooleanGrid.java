package games.tetris.engine.grid;

import games.util.grid.AbstractVirtual2DGrid;
import games.util.grid.GridOutOfBoundsException;

/**
 * A 2d grid whose internal state is synchronized so that it can be manipulated by different threads.
 * 
 * @author edwin
 *
 */
public class ThreadSafeVirtual2DBooleanGrid extends AbstractVirtual2DGrid<Boolean> {

	private final Boolean[][] grid;

	private final GridStateLogger<Boolean> gridLogger;

	public ThreadSafeVirtual2DBooleanGrid(int width, int height) {
		super(width, height);
		this.grid = new Boolean[width][height];
		this.gridLogger = new GridStateLogger<>(this);
	}

	/**
	 * {@inheritDoc} Everything else then {@link Boolean#TRUE} will be interpreted as {@link Boolean#FALSE}.
	 */
	@Override
	public synchronized Boolean getObjectAtPosition(int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		if (this.grid[x][y] == Boolean.TRUE) {
			return this.grid[x][y];
		} else {
			return Boolean.FALSE;
		}
	}


	@Override
	public synchronized void setObjectAtPosition(Boolean object, int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		this.grid[x][y] = object;
		this.gridLogger.logGridState();
	}
}