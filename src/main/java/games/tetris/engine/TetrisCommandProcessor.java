package games.tetris.engine;

import games.tetris.engine.grid.TetrisGridController;
import games.util.command.generic.MoveCommand;
import games.util.grid.GridController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.Validate;

/**
 * Class that represents the command executor part of the Tetris Engine. Via this class, different threads can request to perform commands and block on them until the executor has finished them.
 * 
 * @author edwin
 *
 */
public class TetrisCommandProcessor {

	private final ExecutorService processor;
	private final GridController gridController;

	public TetrisCommandProcessor() {
		this.processor = Executors.newSingleThreadExecutor();
		this.gridController = new TetrisGridController();
	}

	public Future<MoveCommand<Object>> performMoveAction(final MoveCommand<Object> moveCommand) { //TODO In later version, switch Object to some sort of Tetris object
		Validate.notNull(moveCommand, "Move Command is null.");

		MoveTask moveTask = new MoveTask(this.gridController, moveCommand);
		return this.processor.submit(moveTask);
	}

	/**
	 * Method to be called when the processor needs to be stopped, for example when the program ends. This method will clean all resources and memory.
	 */
	public void shutdown() {
		this.processor.shutdown();
	}
}