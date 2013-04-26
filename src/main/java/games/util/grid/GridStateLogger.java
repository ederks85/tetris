package games.util.grid;

import org.apache.commons.lang.Validate;

/**
 * Class that logs the state of a grid to a file. The log will show '0' where grid locations are emtpy and '1' where grid locations are filled with an object.
 * 
 * @author edwin
 *
 */
class GridStateLogger<T> {

	private final Virtual2DGrid<T> grid;

	public GridStateLogger(Virtual2DGrid<T> grid) {
		Validate.notNull(grid, "Grid is null");
		this.grid = grid;
	}

	public void logGridState() {
		//TODO Configure to log to other sources

		System.out.print("Start Logging Grid State:" + System.getProperty("line.separator"));
		for (int i=0; i < this.grid.getGridDimensions().height; i++) {
			for (int j=0; j < this.grid.getGridDimensions().width; j++) {
				try {
					System.out.print(" " + (this.grid.getObjectAtPosition(j, i) == Boolean.FALSE ? "0" : "1"));
				} catch (GridOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
			System.out.print(System.getProperty("line.separator"));
		}
		System.out.println("Finished Logging Grid State" + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator"));
	}
}