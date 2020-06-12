package games.tetris.generic.grid;

/**
 * Basic implementation for {@code Virtual2DGrid}.
 * 
 * @author edwin
 *
 */
public abstract class AbstractVirtual2DGrid<T> implements Virtual2DGrid<T> {

	private final int widht;
	private final int height;

	public AbstractVirtual2DGrid(int width, int height) {
		this.widht = width;
		this.height = height;
	}

	@Override
	public Dimension getGridDimensions() {
		return new Dimension(this.widht, this.height);
	}

	protected void checkPosition(int x, int y) throws GridOutOfBoundsException {
		if (x < 0 || x >= getGridDimensions().getWidth()) {
			System.out.println("Position " + x + " exceeds grid width between 0 and " +  getGridDimensions().getWidth());
			throw new GridOutOfBoundsException("Position " + x + " exceeds grid width between 0 and " +  getGridDimensions().getWidth());
		}
		if (y < 0 || y >= getGridDimensions().getHeight()) {
			System.out.println("Position " + y + " exceeds grid height between 0 and " + getGridDimensions().getHeight());
			throw new GridOutOfBoundsException("Position " + y + " exceeds grid height between 0 and " + getGridDimensions().getHeight());
		}
	}
}