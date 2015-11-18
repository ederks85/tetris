package games.tetris.engine.game;

import java.util.concurrent.Callable;

import org.apache.commons.lang3.Validate;

import games.tetris.engine.object.TetrisObject;
import games.util.command.generic.MultiLocationMoveCommand;
import games.util.grid.GridController;

/**
 * Class that wraps performing the move command on the actual grid.
 * 
 * @author edwin
 *
 */
public class MoveTask implements Callable<MultiLocationMoveCommand<TetrisObject>> {

	private final GridController gridController;
	private final MultiLocationMoveCommand<TetrisObject> moveCommand;

	/**
	 * Provide the task with the necessary resources to perform a move task on a grid via a controller.
	 * 
	 * @param gridController	the grid controller that will perform the 
	 * @param moveCommand		the details of the move
	 */
	public MoveTask(GridController gridController, MultiLocationMoveCommand<TetrisObject> moveCommand) {
		Validate.notNull(gridController, "Grid controller is null");
		Validate.notNull(moveCommand, "Move command is null");

		this.gridController = gridController;
		this.moveCommand = moveCommand;
	}

	@Override
	public MultiLocationMoveCommand<TetrisObject> call() throws Exception {
		this.gridController.moveObject(this.moveCommand);
		return this.moveCommand;
	}
}