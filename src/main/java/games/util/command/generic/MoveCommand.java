package games.util.command.generic;

/**
 * Interface that defines a command for moving a specific object from one position to another.
 * 
 * @author edwin
 *
 * @param <T> the type of object that is to be moved
 * @param <V> the type of object that contains the location of the object, or locations of the object when the object is a composite object.
 * 
 * @see SingleLocationMoveCommand
 * @see MultiLocationMoveCommand
 */
public interface MoveCommand<T, V> {

	/**
	 * @return the object where a move command will be performed for. Never null.
	 */
	T getObject();

	/**
	 * @return The current location(s) the object resides at. Can never be null.
	 */
	V getCurrentLocation();

	/**
	 * @return the location(s) after the move command has been performed.
	 */
	V getNewLocation();
}