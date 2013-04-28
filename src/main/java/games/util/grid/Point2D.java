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
}