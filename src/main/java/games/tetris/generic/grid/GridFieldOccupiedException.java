package games.tetris.generic.grid;

/**
 * Exception that can be thrown when an object is tried to being placed at a location in a grid that is already occupied.
 * 
 * @author edwin
 *
 */
public class GridFieldOccupiedException extends Exception {

	private static final long serialVersionUID = -7449603137743115398L;

	public GridFieldOccupiedException(String message) {
		super(message);
	}
}