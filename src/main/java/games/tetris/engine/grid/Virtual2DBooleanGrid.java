package games.tetris.engine.grid;

import games.util.grid.AbstractVirtual2DGrid;
import games.util.grid.GridOutOfBoundsException;

/**
 * A 2d grid that uses {@link Boolean#TRUE} to mark filled grid fields and {@link Boolean#FALSE} to mark empty grid fields.
 * 
 * @author edwin
 *
 */
public class Virtual2DBooleanGrid extends AbstractVirtual2DGrid<Boolean> {

	private final Boolean[][] grid;

	private final GridStateLogger<Boolean> gridLogger;

	public Virtual2DBooleanGrid(int width, int height) {
		super(width, height);
		this.grid = new Boolean[width][height];
		this.gridLogger = new GridStateLogger<>(this);
	}

	/**
	 * {@inheritDoc} Everything else then {@link Boolean#TRUE} will be interpreted as {@link Boolean#FALSE}.
	 */
	@Override
	public Boolean getObjectAtPosition(int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		if (this.grid[x][y] == Boolean.TRUE) {
			return this.grid[x][y];
		} else {
			return Boolean.FALSE;
		}
	}


	@Override
	public void setObjectAtPosition(Boolean object, int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		this.grid[x][y] = object;
		this.gridLogger.logGridState();
	}
}