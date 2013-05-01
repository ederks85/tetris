package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;

/**
 * Default implementation of {@code TetrisGameState} that can safely be shared between components.
 * 
 * @author edwin
 *
 */
public class ThreadSafeTetrisGameState implements TetrisGameState {

	@Override
	public TetrisObject getCurrentTetrisObject() {
		return null;
	}

	public void setCurrentTetrisObject(TetrisObject currentTetrisObject) {
		
	};
}