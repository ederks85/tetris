package games.tetris.engine.object;

import java.util.Arrays;

import org.apache.commons.lang.Validate;

import games.util.grid.Point2D;

/**
 * Immutable object that contains the data for determining various {@code TetrisObject} shapes.
 * 
 * @author edwin
 *
 */
public class TetrisObjectShape {

	private final int width;
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

	public int getWidth() {
		return this.width;
	}

	public int getHeigth() {
		return this.heigth;
	}

	/**
	 * @return A copy of the occupied locations that mark the shape of a {@code TetrisObject}.
	 */
	public Point2D[] getOccupiedLocations() {
		return Arrays.copyOf(this.occupiedLocations, this.occupiedLocations.length);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.heigth;
		result = prime * result + Arrays.hashCode(this.occupiedLocations);
		result = prime * result + this.width;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof TetrisObjectShape)) {
			return false;
		}

		TetrisObjectShape other = (TetrisObjectShape) obj;
		if (this.heigth != other.heigth) {
			return false;
		}

		if (!Arrays.equals(this.occupiedLocations, other.occupiedLocations)) {
			return false;
		}

		if (this.width != other.width) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " widht=" + this.width + ", height=" + this.heigth + ", occupiedLocations=" + this.occupiedLocations;
	}
}