package games.tetris.engine.object;

import java.awt.Dimension;

import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Point2D;
import games.util.grid.Virtual2DBooleanGrid;

import org.apache.commons.lang.Validate;

/**
 * Tetris object whose layout/shape is defined by a boolean grid where {@link Boolean#TRUE} defines the occupied locations that mark the shape. 
 * 
 * Examples are:
 * 
 * 1 0
 * 1 1
 * 0 1
 *
 * 1 0 0
 * 1 1 1
 * 
 * Note that this object only defines the initial form of the object. Variations of this object by "rotating" it must be defined as separate forms.
 * 
 * @author edwin
 *
 */
public class ImmutableTetrisObject extends Virtual2DBooleanGrid implements TetrisObject {

	private final int numberOfPositions;

	public ImmutableTetrisObject(int width, int height, Point2D[] occupiedLocations) throws GridOutOfBoundsException {
		super(width, height);

		Validate.notEmpty(occupiedLocations, "No occupied locations are provided");
		for (Point2D occupiedlocation : occupiedLocations) {
			this.setObjectAtPosition(Boolean.TRUE, occupiedlocation.getX(), occupiedlocation.getY());
		}

		this.numberOfPositions = occupiedLocations.length;
	}

	@Override
	public Dimension getDimensions() {
		return this.getGridDimensions();
	}

	@Override
	public Boolean isPositionOccupied(int x, int y) throws GridOutOfBoundsException {
		return this.getObjectAtPosition(x, y);
	}

	@Override
	public int getNumberOfPositions() {
		return this.numberOfPositions;
	}
}