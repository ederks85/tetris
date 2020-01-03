package games.util.grid;

import java.util.Objects;

/**
 * Immutable class that represents a 2D location.
 * 
 * @author edwin
 *
 */
public class Point2D {

	int x;
	int y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Point2D)) return false;
		Point2D point2D = (Point2D) o;
		return x == point2D.x &&
				y == point2D.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public String toString() {
		return String.format("Point2D{x=%d, y=%d}", this.x, this.y);
	}
}