package games.tetris.engine.ai;

/**
 * The AI that schedules the timed move commands on the engine.
 * 
 * @author edwin
 *
 */
public class TetrisAI {

	private int interval; //TODO Key part of speed difficulty.

	public TetrisAI() {
		this.interval = 1000; //(milliseconds) TODO make interval configurable
	}
}