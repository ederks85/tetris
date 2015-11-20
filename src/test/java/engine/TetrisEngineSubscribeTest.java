package engine;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.game.TetrisGame;

/**
 * @author edwin
 *
 */
public class TetrisEngineSubscribeTest {

	private TetrisGame g;

	private TetrisAI ai;

	@Before
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