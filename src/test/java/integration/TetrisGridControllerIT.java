package integration;

import games.tetris.engine.grid.TetrisGridController;
import games.tetris.engine.object.TetrisObject;
import games.tetris.engine.object.TetrisObjectFactory;
import games.tetris.util.command.generic.SingleLocationMoveCommand;
import games.tetris.util.command.generic.ThreadSafeSingleLocationMoveCommand;
import games.tetris.util.grid.Dimension;
import games.tetris.util.grid.GridFieldOccupiedException;
import games.tetris.util.grid.GridOutOfBoundsException;
import games.tetris.util.grid.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Edwin on 29-7-2016.
 */
public class TetrisGridControllerIT {

    @Test
    public void test_move_single_location_tetris_object_on_grid_until_reaching_bottom_border() throws GridFieldOccupiedException, GridOutOfBoundsException {

        final TetrisGridController controller = new TetrisGridController();
        final TetrisObject tetrisObject = TetrisObjectFactory.createRandomTetrisObject();

        final Dimension gridDimensions = controller.getGridDimensions();

        assertTrue(gridDimensions.getWidth() > 0);
        assertTrue(gridDimensions.getHeight() > 0);

        for (int i = 0; i < gridDimensions.getHeight(); i++) {
            SingleLocationMoveCommand<Point2D> moveCommand = new ThreadSafeSingleLocationMoveCommand(tetrisObject, new Point2D(0, i), new Point2D(0, i));
            controller.moveObject(moveCommand);
        }
    }

    @Test
    public void test_move_single_location_tetris_object_on_grid_overstepping_bottom_border() throws GridFieldOccupiedException, GridOutOfBoundsException {

        final TetrisGridController controller = new TetrisGridController();
        final TetrisObject tetrisObject = TetrisObjectFactory.createRandomTetrisObject();

        final Dimension gridDimensions = controller.getGridDimensions();

        assertTrue(gridDimensions.getWidth() > 0);
        assertTrue(gridDimensions.getHeight() > 0);

        assertThrows(GridOutOfBoundsException.class, () -> {
            for (int i = 0; i < gridDimensions.getHeight() + 1; i++) {
                SingleLocationMoveCommand<Point2D> moveCommand = new ThreadSafeSingleLocationMoveCommand(tetrisObject, new Point2D(0, i), new Point2D(0, i));
                controller.moveObject(moveCommand);
            }
        } );
    }
}
