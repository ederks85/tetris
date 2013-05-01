package games.tetris.engine.object;

/**
 * Factory class for retrieving the available Tetris objects.
 * 
 * @author edwin
 *
 */
public final class TetrisObjectFactory {

	private TetrisObjectFactory() {}

	/**
	 * Get a randomly generated Tetris object.
	 * 
	 * @return A new instance of Tetris object. Never null.
	 */
	public static TetrisObject getRandomTetrisObject() {
		return new TetrisObject(){};
	}
}