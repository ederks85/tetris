package engine;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import games.tetris.engine.game.TetrisGame;

/**
 * @author edwin
 *
 */
public class BasicTetrisEngineTest {

	@Test
	public void tetrisEngineRunTest() {
		// Start game
		TetrisGame g = new TetrisGame();
		assertFalse(g.isShutdown());

		// Shutdown game
		g.shutdown();
		assertTrue(g.isShutdown());
	}
}