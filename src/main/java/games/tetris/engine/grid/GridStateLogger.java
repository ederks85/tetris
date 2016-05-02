package games.tetris.engine.grid;

import java.io.IOException;
import java.io.RandomAccessFile;

import lombok.NonNull;
import org.apache.commons.lang3.Validate;

import games.util.grid.Virtual2DGrid;

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
	private RandomAccessFile file;

	GridStateLogger(@NonNull Virtual2DGrid<T> grid) {
		this.grid = grid;
		try {
			this.file = new RandomAccessFile("c:\\temp\\tetris.log", "rw");
			this.file.setLength(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void logGridState() {
//		try {
	//		System.out.print("Start Logging Grid State:" + System.getProperty("line.separator"));
	//		this.file.setLength(0);
//			for (int i=0; i < this.grid.getGridDimensions().getHeight(); i++) {
//				for (int j=0; j < this.grid.getGridDimensions().getWidth(); j++) {
//					try {
//						this.file.writeChars(" " + (this.grid.getObjectAtPosition(j, i) == (Boolean.TRUE) ? "1" : "0"));
//					} catch (GridOutOfBoundsException e) {
//						e.printStackTrace();
//					}
	//			}
//				this.file.writeChars(System.getProperty("line.separator"));
	//			System.out.print(System.getProperty("line.separator"));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Finished Logging Grid State" + System.getProperty("line.separator") + System.getProperty("line.separator") + System.getProperty("line.separator"));
	}
}