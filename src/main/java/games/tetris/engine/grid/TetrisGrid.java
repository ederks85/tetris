package games.tetris.engine.grid;

import games.util.grid.AbstractVirtual2DGrid;
import games.util.grid.GridOutOfBoundsException;

/**
 * A 2d grid that uses {@link Boolean#TRUE} to mark filled grid fields and {@link Boolean#FALSE} to mark empty grid fields.
 * 
 * @author edwin
 *
 */
public class TetrisGrid extends AbstractVirtual2DGrid<Boolean> {

	private final Boolean[][] grid;

	public TetrisGrid(int width, int height) {
		super(width, height);
		this.grid = new Boolean[width][height];
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
	}
}