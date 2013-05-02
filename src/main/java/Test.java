import games.tetris.engine.ai.TetrisAI;
import games.tetris.engine.game.TetrisGame;
import games.util.grid.GridFieldOccupiedException;
import games.util.grid.GridOutOfBoundsException;

import java.util.concurrent.ExecutionException;

/**
 * @author edwin
 *
 */
public class Test {

	public static void main(String[] args) throws GridOutOfBoundsException, GridFieldOccupiedException, ExecutionException, InterruptedException {

		TetrisGame g = new TetrisGame();
		TetrisAI ai = new TetrisAI();
		g.subscribe(ai);
		ai.start();
	}
}