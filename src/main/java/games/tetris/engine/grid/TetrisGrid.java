package games.tetris.engine.grid;

import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Virtual2DBooleanGrid;

/**
 * A 2d grid that uses {@link Boolean#TRUE} to mark filled grid fields and {@link Boolean#FALSE} to mark empty grid fields.
 * 
 * @author edwin
 *
 */
public class TetrisGrid extends Virtual2DBooleanGrid { //TODO use a Virtual2DBooleanGrid when logging no specific code is needed anymore

	public TetrisGrid(int width, int height) {
		super(width, height);
	}

	@Override
	public void setObjectAtPosition(Boolean object, int x, int y) throws GridOutOfBoundsException {
		super.setObjectAtPosition(object, x, y);
	}
}