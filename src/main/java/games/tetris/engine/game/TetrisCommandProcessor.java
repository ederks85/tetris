package games.tetris.engine.game;

import games.tetris.engine.grid.TetrisGridController;
import games.tetris.engine.object.TetrisObject;
import games.util.command.generic.MultiLocationMoveCommand;
import games.util.grid.GridController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Class that represents the command executor part of the Tetris Engine. Via this class, different threads can request to perform commands and block on them until the executor has finished them.
 * 
 * @author edwin
 *
 */
public class TetrisCommandProcessor { //TODO maybe make interface of this, more clean though initially it seemed over-designed

	private final ExecutorService processor;
	private final GridController gridController;

	TetrisCommandProcessor() {
		this.processor = Executors.newSingleThreadExecutor();
		this.gridController = new TetrisGridController();
	}

	public Future<MultiLocationMoveCommand<TetrisObject>> performMoveAction(final MultiLocationMoveCommand<TetrisObject> moveCommand) {
		if (moveCommand == null) {
			throw new IllegalArgumentException("MultiLocationMoveCommand is null");
		}

		return this.processor.submit(new MoveTask(this.gridController, moveCommand));
	}

	/**
	 * Method to be called when the processor needs to be stopped, for example when the program ends. This method will clean all resources and memory. Should not 
	 * be called and even be available to only the component that manages the instance of this class.
	 */
	void shutdown() {
		this.processor.shutdown();
	}

	boolean isShutdown() {
		return this.processor.isShutdown();
	}
}