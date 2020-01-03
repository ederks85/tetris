package games.tetris.engine.game;

import games.tetris.engine.object.TetrisObject;
import games.util.command.generic.MultiLocationMoveCommand;
import games.util.grid.GridController;
import lombok.NonNull;

import java.util.concurrent.Callable;

/**
 * Class that wraps performing the move command on the actual grid.
 * 
 * @author edwin
 *
 */
class MoveTask implements Callable<MultiLocationMoveCommand<TetrisObject>> {

	private final GridController gridController;
	private final MultiLocationMoveCommand<TetrisObject> moveCommand;

	/**
	 * Provide the task with the necessary resources to perform a move task on a grid via a controller.
	 * 
	 * @param gridController	the grid controller that will perform the 
	 * @param moveCommand		the details of the move
	 */
	MoveTask(@NonNull GridController gridController, @NonNull MultiLocationMoveCommand<TetrisObject> moveCommand) {
		this.gridController = gridController;
		this.moveCommand = moveCommand;
	}

	@Override
	public MultiLocationMoveCommand<TetrisObject> call() throws Exception {
		this.gridController.moveObject(this.moveCommand);
		return this.moveCommand;
	}
}