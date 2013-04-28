import games.tetris.engine.grid.TetrisGridController;
import games.util.command.generic.MoveCommand;
import games.util.command.generic.ThreadSafeMoveCommand;
import games.util.grid.GridFieldOccupiedException;
import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Point2D;

/**
 * @author edwin
 *
 */
public class Test {

	public static void main(String[] args) throws GridOutOfBoundsException, GridFieldOccupiedException {

		MoveCommand<Object> com1 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(0,0), new Point2D(5,1));
		MoveCommand<Object> com2 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,1), new Point2D(5,2));
		MoveCommand<Object> com3 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,2), new Point2D(5,3));
		MoveCommand<Object> com4 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,3), new Point2D(5,4));
		MoveCommand<Object> com5 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,4), new Point2D(5,5));
		MoveCommand<Object> com6 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,5), new Point2D(5,6));
		MoveCommand<Object> com7 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,6), new Point2D(5,7));
		MoveCommand<Object> com8 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,7), new Point2D(5,8));
		MoveCommand<Object> com9 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,8), new Point2D(5,9));

		TetrisGridController g = new TetrisGridController();
		g.moveObject(com1);
		g.moveObject(com2);
		g.moveObject(com3);
		g.moveObject(com4);
		g.moveObject(com5);
		g.moveObject(com6);
		g.moveObject(com7);
		g.moveObject(com8);
		g.moveObject(com9);
		
	}
}