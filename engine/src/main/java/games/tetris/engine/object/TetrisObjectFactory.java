package games.tetris.engine.object;

import games.tetris.generic.grid.GridOutOfBoundsException;
import games.tetris.generic.grid.Point2D;

/**
 * Factory class for retrieving the available Tetris objects.
 * 
 * @author edwin
 *
 */
public final class TetrisObjectFactory {

	private static final Point2D[] TETRISOBJECT1_SHAPE_DETAILS;
	static {
		TETRISOBJECT1_SHAPE_DETAILS = new Point2D[]{new Point2D(0, 0), new Point2D(0, 1), new Point2D(1, 1), new Point2D(1, 2)};
	}

	private TetrisObjectFactory() {}

	/**
	 * Get a randomly generated {@code TetrisObject}.
	 * 
	 * @return A new instance of {@code TetrisObject}. Never null.
	 */
	public static TetrisObject createRandomTetrisObject() {
		final TetrisObjectShape shape = new TetrisObjectShape(TETRISOBJECT1_SHAPE_DETAILS); //TODO randomize

		try {
			return new ImmutableTetrisObject(shape.getWidth(), shape.getHeigth(), shape.getOccupiedLocations());
		} catch (GridOutOfBoundsException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Invalid specifications for TetrisObject found", e);
		}
	}
}