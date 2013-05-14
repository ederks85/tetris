package games.util.grid;

/**
 * Class that represents the dimensions of a 2D object.
 * 
 * @author edwin
 *
 */
public class Dimension {

	private final int width;
	private final int height;

	public Dimension(int x, int y) {
		this.width = x;
		this.height = y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": width=" + this.width + ", height=" + this.height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;

		int result = 1;
		result = prime * result + width;
		result = prime * result + height;

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

		if (!(obj instanceof Dimension)) {
			return false;
		}

		Dimension other = (Dimension) obj;

		if (width != other.width) {
			return false;
		}

		if (height != other.height) {
			return false;
		}

		return true;
	}
}