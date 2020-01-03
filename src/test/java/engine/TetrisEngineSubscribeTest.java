package engine;

import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.game.TetrisGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author edwin
 *
 */
public class TetrisEngineSubscribeTest {

	private TetrisGame g;

	private TetrisAI ai;

	@BeforeAll
	public void init() {
		g = new TetrisGame();
		ai = new TetrisAI();
	}

	@Test
	public void tetrisEngineRunningTest() {
		assertFalse(g.isShutdown());
	}

	@Test	
	public void subscribeAI() {
		g.subscribe(ai);
		assertEquals(1, g.getSubscribers().size());
	}

	@Test
	public void subscribeNullAI() {
		assertThrows(IllegalArgumentException.class, () -> g.subscribe(null));
	}

	@Test
	public void unsubscribeAI() {
		g.unsubscribe(ai);
		assertTrue(g.getSubscribers().isEmpty());
	}

	@Test
	public void tetrisEngineShutdownTest() {
		assertFalse(g.isShutdown());

		// Shutdown game
		g.shutdown();
		assertTrue(g.isShutdown());
	}
}