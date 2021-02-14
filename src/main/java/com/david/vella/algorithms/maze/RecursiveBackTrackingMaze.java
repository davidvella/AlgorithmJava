package com.david.vella.algorithms.maze;

import java.util.Arrays;
import java.util.Collections;

/*
 * Recursive backtracking algorithm. Please look at inspiration:
 * http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
 *
 * How it works
 * 1. Choose a starting point in the field.
 * 2. Randomly choose a wall at that point and carve a passage through to the adjacent cell,
 * but only if the adjacent cell has not been visited yet. This becomes the new current cell.
 * 3. If all adjacent cells have been visited, back up to the last cell that has uncarved walls and repeat.
 * 4. The algorithm ends when the process has backed all the way up to the starting point.
 *
 */
public class RecursiveBackTrackingMaze extends AbstractMaze{
    /**
     * Create a new maze of size and width
     *
     * @param width  Width of the maze
     * @param height Height of the maze
     */
    public RecursiveBackTrackingMaze(int width, int height) {
        super(width, height);
    }

    @Override
    public void generateMaze() {
        addWallsToAllPoints();
        generateMaze(0,0);
    }


    /**
     * Generate Maze
     * @param cx Starting x co-ordinate
     * @param cy Starting y co-ordinate
     */
    void generateMaze(int cx, int cy) {
        // Creates a list of directions that ought to be tried from the current cell
        // We sort the list in random order, so that the path will meander, rather than having a bias in any particular direction.
        MazePassageDirection[] dirs = MazePassageDirection.values();
        Collections.shuffle(Arrays.asList(dirs));

        points[cx][cy].setVisited();

        for (MazePassageDirection dir : dirs) {
            int nx = cx + dir.directionX;
            int ny = cy + dir.directionY;

            // Check whether next direction is not out of bounds and has not been visited.
            if (isCoOrdinatesInBounds(nx,ny)
                    && !points[nx][ny].hasBeenVisited()) {
                // Cell is valid
                points[cx][cy].removeState(dir.state);
                points[nx][ny].removeState(dir.opposite.state);
                generateMaze(nx, ny);
            }
        }
    }
}
