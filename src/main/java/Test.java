import games.tetris.engine.grid.ThreadSafeVirtual2DBooleanGrid;
import games.util.grid.GridOutOfBoundsException;

/**
 * EGIT test
 * 
 * @author edwin
 *
 */
public class Test {

	public static void main(String[] args) throws GridOutOfBoundsException {

		ThreadSafeVirtual2DBooleanGrid grid = new ThreadSafeVirtual2DBooleanGrid(3, 6);

		System.out.println("Initial grid size: " + grid.getGridDimensions());

		int x = 1;
		int y = 2;
		System.out.println("Grid object at (" + x + "," + y + "): " + grid.getObjectAtPosition(x, y));

		grid.setObjectAtPosition(true, x, y);
		grid.setObjectAtPosition(false, x, y);

		x = 1;
		y = 3;

		grid.setObjectAtPosition(true, x, y);
		grid.setObjectAtPosition(false, x, y);

		x = 1;
		y = 4;

		grid.setObjectAtPosition(true, x, y);
		grid.setObjectAtPosition(false, x, y);

		System.out.println("Grid object at (" + x + "," + y + "): " + grid.getObjectAtPosition(x, y));
	}
}