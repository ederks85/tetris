package games.util.grid;

import java.awt.Dimension;

/**
 * A 2d grid whose internal state is synchronized so that it can be manipulated by different threads.
 * 
 * @author edwin
 *
 */
public class ThreadSafeVirtual2DGrid implements Virtual2DGrid<Boolean> {

	private final int widht;
	private final int height;

	private final Boolean[][] grid;

	private final GridStateLogger<Boolean> gridLogger;

	public ThreadSafeVirtual2DGrid(int width, int height) {
		this.widht = width;
		this.height = height;

		// Initialze every position as 'false'
		this.grid = new Boolean[width][height];
		for (int i=0; i < this.widht; i++) {
			for (int j=0; j < this.height; j++) {
				this.grid[i][j] = Boolean.FALSE;
			}
		}

		this.gridLogger = new GridStateLogger<Boolean>(this);
	}

	@Override
	public synchronized Dimension getGridDimensions() {
		return new Dimension(this.widht, this.height);
	}

	@Override
	public synchronized Boolean getObjectAtPosition(int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		return this.grid[x][y];
	}

	@Override
	public synchronized void setObjectAtPosition(Boolean object, int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		this.grid[x][y] = object;
		this.gridLogger.logGridState();
	}

	private void checkPosition(int x, int y) throws GridOutOfBoundsException {
		if (x < 0 || x >= this.widht) {
			throw new GridOutOfBoundsException("Position " + x + " exceeds grid width of " + this.widht);
		}
		if (y < 0 || y >= this.height) {
			throw new GridOutOfBoundsException("Position " + x + " exceeds grid height of " + this.height);
		}
	}
}