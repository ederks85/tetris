package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;

/**
 * Container object that holds sharable, possibly persistent state of the Tetris game.
 * 
 * @author edwin
 *
 */
public interface TetrisGameState {

	/**
	 * Get the object that is currently in play.
	 * 
	 * @return
	 */
	TetrisObject getCurrentTetrisObject();

	/**
	 * Set the object that becomes the object returned by {@link #getCurrentTetrisObject()}.
	 * 
	 * @param currentTetrisObject A new object to play with or provide {@code null} to clear the current object.
	 */
	void setCurrentTetrisObject(TetrisObject currentTetrisObject);
}