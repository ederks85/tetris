package engine;

import games.tetris.engine.game.TetrisGame;
import games.tetris.engine.grid.TetrisGridController;
import games.tetris.engine.object.TetrisObject;
import games.tetris.engine.object.TetrisObjectFactory;
import games.util.command.generic.SingleLocationMoveCommand;
import games.util.command.generic.ThreadSafeSingleLocationMoveCommand;
import games.util.grid.Dimension;
import games.util.grid.GridFieldOccupiedException;
import games.util.grid.GridOutOfBoundsException;
import games.util.grid.Point2D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Edwin on 29-7-2016.
 */
public class TetrisGridControllerTest {

    @Before
    public void init() {

    }

    @Test
    public void test_move_single_location_tetris_object_on_grid_until_reaching_bottom_border() throws GridFieldOccupiedException, GridOutOfBoundsException {

        final TetrisGridController controller = new TetrisGridController();
        final TetrisObject tetrisObject = TetrisObjectFactory.createRandomTetrisObject();

        final Dimension gridDimensions = controller.getGridDimensions();

        Assert.assertTrue(gridDimensions.getWidth() > 0);
        Assert.assertTrue(gridDimensions.getHeight() > 0);

        for (int i = 0; i < gridDimensions.getHeight(); i++) {
            SingleLocationMoveCommand<Point2D> moveCommand = new ThreadSafeSingleLocationMoveCommand(tetrisObject, new Point2D(0, i), new Point2D(0, i));
            controller.moveObject(moveCommand);
        }
    }

    @Test(expected = GridOutOfBoundsException.class)
    public void test_move_single_location_tetris_object_on_grid_overstepping_bottom_border() throws GridFieldOccupiedException, GridOutOfBoundsException {

        final TetrisGridController controller = new TetrisGridController();
        final TetrisObject tetrisObject = TetrisObjectFactory.createRandomTetrisObject();

        final Dimension gridDimensions = controller.getGridDimensions();

        Assert.assertTrue(gridDimensions.getWidth() > 0);
        Assert.assertTrue(gridDimensions.getHeight() > 0);

        for (int i = 0; i < gridDimensions.getHeight() + 1; i++) {
            SingleLocationMoveCommand<Point2D> moveCommand = new ThreadSafeSingleLocationMoveCommand(tetrisObject, new Point2D(0, i), new Point2D(0, i));
            controller.moveObject(moveCommand);
        }
    }
}
