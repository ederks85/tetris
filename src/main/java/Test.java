import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import games.tetris.engine.TetrisCommandProcessor;
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

	public static void main(String[] args) throws GridOutOfBoundsException, GridFieldOccupiedException, ExecutionException, InterruptedException {

		MoveCommand<Object> com1 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(0,0), new Point2D(5,0));
		MoveCommand<Object> com2 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,0), new Point2D(5,1));
		MoveCommand<Object> com3 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,1), new Point2D(5,2));
		MoveCommand<Object> com4 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,2), new Point2D(5,3));
		MoveCommand<Object> com5 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,3), new Point2D(5,4));
		MoveCommand<Object> com6 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,4), new Point2D(5,5));
		MoveCommand<Object> com7 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,5), new Point2D(5,6));
		MoveCommand<Object> com8 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,6), new Point2D(5,7));
		MoveCommand<Object> com9 = new ThreadSafeMoveCommand<Object>(new Object(), new Point2D(5,7), new Point2D(5,8));

		TetrisCommandProcessor g = new TetrisCommandProcessor();
		Future<MoveCommand<Object>> a1 = g.performMoveAction(com1);
		a1.get();
		Future<MoveCommand<Object>> a2 = g.performMoveAction(com2);
		a2.get();
		Future<MoveCommand<Object>> a3 = g.performMoveAction(com3);
		a3.get();
		Future<MoveCommand<Object>> a4 = g.performMoveAction(com4);
		a4.get();
		Future<MoveCommand<Object>> a5 = g.performMoveAction(com5);
		a5.get();
		Future<MoveCommand<Object>> a6 = g.performMoveAction(com6);
		a6.get();
		Future<MoveCommand<Object>> a7 = g.performMoveAction(com7);
		a7.get();
		Future<MoveCommand<Object>> a8 = g.performMoveAction(com8);
		a8.get();
		Future<MoveCommand<Object>> a9 = g.performMoveAction(com9);
		a9.get();

		g.shutdown();
	}
}