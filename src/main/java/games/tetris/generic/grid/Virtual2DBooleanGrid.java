package games.tetris.generic.grid;

/**
 * A 2d grid that uses {@link Boolean#TRUE} to mark filled grid fields and {@link Boolean#FALSE} to mark empty grid fields.
 * 
 * @author edwin
 *
 */
public class Virtual2DBooleanGrid extends AbstractVirtual2DGrid<Boolean> {

	private final boolean[][] grid;

	public Virtual2DBooleanGrid(int width, int height) {
		super(width, height);
		this.grid = new boolean[width][height];
	}

	/**
	 * {@inheritDoc} Everything else then {@link Boolean#TRUE} will be interpreted as {@link Boolean#FALSE}.
	 */
	@Override
	public Boolean getObjectAtPosition(int x, int y) throws GridOutOfBoundsException {
		checkPosition(x, y);
		if (this.grid[x][y] == true) {
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