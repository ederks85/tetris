package games.tetris.util.command.generic;

import games.tetris.util.grid.Point2D;


/**
 * Interface that defines a command for moving a specific composite object to new positions.
 * 
 * @author edwin
 *
 */
public interface MultiLocationMoveCommand<T> extends MoveCommand<T, Point2D[]> {

}