package engine;

import games.tetris.engine.game.TetrisGame;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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