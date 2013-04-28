package games.tetris.engine;

import games.tetris.engine.grid.TetrisGridController;
import games.util.command.generic.MoveCommand;
import games.util.grid.GridController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.Validate;

/**
 * Class that represents the Tetris Engine. Via this class, different threads can ask the enigne to perform commands and block on them until the engine has finished them.
 * 
 * @author edwin
 *
 */
public class TetrisEngine {

	private final ExecutorService engine;
	private final GridController gridController;

	public TetrisEngine() {
		this.engine = Executors.newSingleThreadExecutor();
		this.gridController = new TetrisGridController();
	}

	public Future<MoveCommand<Object>> performMoveAction(final MoveCommand<Object> moveCommand) { //TODO In later version, switch Object to some sort of Tetris object
		Validate.notNull(moveCommand, "Move Command is null.");

		MoveTask moveTask = new MoveTask(this.gridController, moveCommand);
		return this.engine.submit(moveTask);
	}

	/**
	 * Method to be called when the engine needs to be stopped, for example when the program ends. This method will clean all resources and memory.
	 */
	public void shutdown() {
		this.engine.shutdown();
	}
}