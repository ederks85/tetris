package games.tetris.generic.command;

import games.tetris.generic.grid.Point2D;


/**
 * Interface that defines a command for moving a specific object from one position to another.
 * 
 * @author edwin
 *
 */
public interface SingleLocationMoveCommand<T> extends MoveCommand<T, Point2D> {

}