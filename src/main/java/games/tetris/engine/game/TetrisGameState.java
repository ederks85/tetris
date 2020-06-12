package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;
import games.tetris.util.grid.Point2D;

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
	 * Get the positions of the composite {@code TetrisObject} that is currently in play resides at.
	 * 
	 * @return The current locations.
	 */
	Point2D[] getCurrentTetrisObjectPositions();

	/**
	 * Update the locations of the composite {@code TetrisObject} that is currently in play.
	 * 
	 * @param newLocations The new locations or {@code null} when the object is no longer in play.
	 */
	void setCurrentTetrisObjectPosition(Point2D[] newLocations);
}