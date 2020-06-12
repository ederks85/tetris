package integration;

import games.tetris.engine.game.TetrisGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author edwin
 *
 */
public class BasicTetrisEngineIT {

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