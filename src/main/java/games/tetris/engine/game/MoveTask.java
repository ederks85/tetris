package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;
import games.util.command.generic.MoveCommand;
import games.util.grid.GridController;

import java.util.concurrent.Callable;

import org.apache.commons.lang.Validate;

/**
 * Class that wraps performing the move command on the actual grid.
 * 
 * @author edwin
 *
 */
public class MoveTask implements Callable<MoveCommand<TetrisObject>> {

	private final GridController gridController;
	private final MoveCommand<TetrisObject> moveCommand;

	/**
	 * Provide the task with the necessary resources to perform a move task on a grid via a controller.
	 * 
	 * @param gridController	the grid controller that will perform the 
	 * @param moveCommand		the details of the move
	 */
	public MoveTask(GridController gridController, MoveCommand<TetrisObject> moveCommand) {
		Validate.notNull(gridController, "Grid controller is null");
		Validate.notNull(moveCommand, "Move command is null");

		this.gridController = gridController;
		this.moveCommand = moveCommand;
	}

	@Override
	public MoveCommand<TetrisObject> call() throws Exception {
		this.gridController.moveObject(this.moveCommand);
		return this.moveCommand;
	}
}