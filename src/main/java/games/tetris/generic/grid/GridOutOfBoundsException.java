package games.tetris.generic.grid;

/**
 * Exception that can be thrown when something is to be done outside the boundaries of a grid.
 * 
 * @author edwin
 *
 */
public class GridOutOfBoundsException extends Exception {

	private static final long serialVersionUID = -330610719252637139L;

	public GridOutOfBoundsException(String message) {
		super(message);
	}
}