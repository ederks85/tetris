package games.tetris.engine.grid;

import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Virtual2DGrid;

import org.apache.commons.lang.Validate;

/**
 * Class that logs the state of a grid to a file. The log will show '0' where grid locations are emtpy and '1' where grid locations are filled with an object.
 * 
 * Comment line for EGIT test
 * 
 * @author edwin
 *
 */
class GridStateLogger<T> {

	private final Virtual2DGrid<T> grid; //TODO Remove when no longer necessary

	public GridStateLogger(Virtual2DGrid<T> grid) {
		Validate.notNull(grid, "Grid is null");
		this.grid = grid;
	}

	public void logGridState() {
		System.out.print("Start Logging Grid State:" + System.getProperty("line.separator"));
		for (int i=0; i < this.grid.getGridDimensions().height; i++) {
			for (int j=0; j < this.grid.getGridDimensions().width; j++) {
				try {
					System.out.print(" " + (this.grid.getObjectAtPosition(j, i) == (Boolean.TRUE) ? "1" : "0"));
				} catch (GridOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
			System.out.print(System.getProperty("line.separator"));
		}
		System.out.println("Finished Logging Grid State" + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator"));
	}
}