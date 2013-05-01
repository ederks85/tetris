import games.tetris.engine.game.TetrisCommandProcessor;
import games.tetris.engine.object.TetrisObject;
import games.util.command.generic.MoveCommand;
import games.util.command.generic.ThreadSafeMoveCommand;
import games.util.grid.GridFieldOccupiedException;
import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Point2D;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author edwin
 *
 */
public class Test {

	public static void main(String[] args) throws GridOutOfBoundsException, GridFieldOccupiedException, ExecutionException, InterruptedException {

		MoveCommand<TetrisObject> com1 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(0,0), new Point2D(5,0));
		MoveCommand<TetrisObject> com2 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,0), new Point2D(5,1));
		MoveCommand<TetrisObject> com3 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,1), new Point2D(5,2));
		MoveCommand<TetrisObject> com4 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,2), new Point2D(5,3));
		MoveCommand<TetrisObject> com5 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,3), new Point2D(5,4));
		MoveCommand<TetrisObject> com6 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,4), new Point2D(5,5));
		MoveCommand<TetrisObject> com7 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,5), new Point2D(5,6));
		MoveCommand<TetrisObject> com8 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,6), new Point2D(5,7));
		MoveCommand<TetrisObject> com9 = new ThreadSafeMoveCommand<TetrisObject>(new TetrisObject(){}, new Point2D(5,7), new Point2D(5,8));

		TetrisCommandProcessor g = new TetrisCommandProcessor();
		Future<MoveCommand<TetrisObject>> a1 = g.performMoveAction(com1);
		a1.get();
		Future<MoveCommand<TetrisObject>> a2 = g.performMoveAction(com2);
		a2.get();
		Future<MoveCommand<TetrisObject>> a3 = g.performMoveAction(com3);
		a3.get();
		Future<MoveCommand<TetrisObject>> a4 = g.performMoveAction(com4);
		a4.get();
		Future<MoveCommand<TetrisObject>> a5 = g.performMoveAction(com5);
		a5.get();
		Future<MoveCommand<TetrisObject>> a6 = g.performMoveAction(com6);
		a6.get();
		Future<MoveCommand<TetrisObject>> a7 = g.performMoveAction(com7);
		a7.get();
		Future<MoveCommand<TetrisObject>> a8 = g.performMoveAction(com8);
		a8.get();
		Future<MoveCommand<TetrisObject>> a9 = g.performMoveAction(com9);
		a9.get();

		//g.shutdown();
	}
}