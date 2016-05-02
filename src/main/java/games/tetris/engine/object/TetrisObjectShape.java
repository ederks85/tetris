package games.tetris.engine.object;

import java.util.Arrays;

import lombok.Getter;
import org.apache.commons.lang3.Validate;

import games.util.grid.Point2D;

/**
 * Immutable object that contains the data for determining various {@code TetrisObject} shapes.
 * 
 * @author edwin
 *
 */
public class TetrisObjectShape {

	@Getter()
	private final int width;

	@Getter
	private final int heigth;

	private final Point2D[] occupiedLocations;

	/**
	 * Provide the specifications for the sha;e. The values for {@link TetrisObjectShape#getWidth()} and {@link TetrisObjectShape#getHeigth()} will be calculated. 
	 * 
	 * @param occupiedLocations
	 */
	public TetrisObjectShape(Point2D[] occupiedLocations) {
		Validate.notEmpty(occupiedLocations, "No occupied locations have been provided");

		int tempWidht = 0;
		int tempHeight = 0;

		for (Point2D occupiedLocation : occupiedLocations) {
			if (occupiedLocation.getX() > tempWidht) {
				tempWidht = (occupiedLocation.getX());
			}

			if (occupiedLocation.getY() > tempHeight) {
				tempHeight = (occupiedLocation.getY());
			}
		}

		this.occupiedLocations = occupiedLocations;
		this.width = tempWidht + 1;
		this.heigth = tempHeight + 1;
	}

	/**
	 * @return A copy of the occupied locations that mark the shape of a {@code TetrisObject}.
	 */
	public Point2D[] getOccupiedLocations() {
		return Arrays.copyOf(this.occupiedLocations, this.occupiedLocations.length);
	}
}