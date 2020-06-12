package games.tetris.generic.grid;

import java.util.Objects;

/**
 * Class that represents the dimensions of a 2D object.
 * 
 * @author edwin
 *
 */
public class Dimension {

	int width;
	int height;

	public Dimension(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Dimension)) return false;
		Dimension dimension = (Dimension) o;
		return width == dimension.width &&
				height == dimension.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(width, height);
	}

	@Override
	public String toString() {
		return String.format("Dimension{width=%d, height=%d}", this.width, this.height);
	}
}