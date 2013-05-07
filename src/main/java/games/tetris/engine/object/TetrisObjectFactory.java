package games.tetris.engine.object;

import java.awt.Dimension;

import games.util.grid.GridOutOfBoundsException;

/**
 * Factory class for retrieving the available Tetris objects.
 * 
 * @author edwin
 *
 */
public final class TetrisObjectFactory {

	private TetrisObjectFactory() {}

	/**
	 * Get a randomly generated {@code TetrisObject}.
	 * 
	 * @return A new instance of {@code TetrisObject}. Never null.
	 */
	public static TetrisObject getRandomTetrisObject() {
		return new TetrisObject(){@Override
		public Boolean isPositionOccupied(int x, int y) throws GridOutOfBoundsException {
			return true;
		}

		@Override
			public Dimension getDimensions() {
				return new Dimension(2,4);
			}
		};
	}
}