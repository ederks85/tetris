package games.util.grid;

/**
 * Class that represents a 2D location.
 * 
 * @author edwin
 *
 */
public class Point2D {

	private final int x;
	private final int y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": x=" + this.x + ",y=" + this.y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;
		result = prime * result + x;
		result = prime * result + y;

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

		if (!(obj instanceof Point2D)) {
			return false;
		}

		Point2D other = (Point2D) obj;

		if (x != other.x) {
			return false;
		}

		if (y != other.y) {
			return false;
		}

		return true;
	}
}