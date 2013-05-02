package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;
import games.util.grid.Point2D;

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
	 * @param newTetrisObject A new object to play with or provide {@code null} to clear the current object.
	 */
	void setCurrentTetrisObject(TetrisObject newTetrisObject);

	/**
	 * Get the position that the {@code TetrisObject} that is currently in play resides at.
	 * 
	 * @return The current location.
	 */
	Point2D getCurrentTetrisObjectPosition();

	/**
	 * Update the location of the {@code TetrisObject} that is currently in play.
	 * 
	 * @param newLocation The new location or {@code null} when the object is no longer in play.
	 */
	void setCurrentTetrisObjectPosition(Point2D newLocation);
}