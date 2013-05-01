package games.tetris.engine.game;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Implementation that can be extended by components that want to subscribe to the Tetris game. The components can implement the {@code TetrisGameSubscriber} methods to schedule commands 
 * and modify the game state.
 * 
 * @author edwin
 *
 */
public abstract class AbstractTetrisGameSubscriber implements TetrisGameSubscriber {

	private AtomicReference<TetrisGameState> tetrisGameState;
	private AtomicReference<TetrisCommandProcessor> tetrisCommandProcessor;

	/**
	 * Method that is to be called when subclass subscribes or unsubscribes to the Tetris Game.
	 * 
	 * @param gameState
	 */
	void setCommandProcessor(final TetrisCommandProcessor commandProcessor) {
		this.tetrisCommandProcessor.set(commandProcessor);
	}

	/**
	 * Method that a subclass can access to obtain the command processor that is available after the subclass has subscribed.
	 * 
	 * @return The provided {@code TetrisCommandProcessor} or {@code null} when the subclass is not subscribed.
	 */
	protected final TetrisCommandProcessor getCommandProcessor() {
		return this.tetrisCommandProcessor.get();
	}
	/**
	 * Method that is to be called when subclass subscribes to or from the Tetris Game.
	 * 
	 * @param gameState
	 */
	void setTetrisGameState(final TetrisGameState gameState) {
		this.tetrisGameState.set(gameState);
	}

	@Override
	public final TetrisGameState getTetrisGameState() {
		return this.tetrisGameState.get();
	}
}