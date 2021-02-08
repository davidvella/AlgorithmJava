package com.david.vella.algorithms.maze;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class IterativeBackTrackingMaze extends AbstractMaze{

    /**
     * Create a new maze of size and width
     *
     * @param width  Width of the maze
     * @param height Height of the maze
     */
    public IterativeBackTrackingMaze(int width, int height) {
        super(width, height);
    }

    @Override
    void generateMaze() {
        addWallsToAllPoints();

        Point initial = getPoint(0,0);
        initial.setVisited();
        Stack<Point> pathStack = new Stack();
        pathStack.add(initial);

        // loop till queue is empty
        while (!pathStack.isEmpty()) {
            Point currentPoint = pathStack.pop();
            // Creates a list of directions that ought to be tried from the current cell
            // We sort the list in random order, so that the path will meander, rather than having a bias in any particular direction.
            MazePassageDirection[] dirs = MazePassageDirection.values();
            Collections.shuffle(Arrays.asList(dirs));
            for (MazePassageDirection dir : dirs) {
                int nx = currentPoint.getX() + dir.directionX;
                int ny = currentPoint.getY() + dir.directionY;
                // Check whether next direction is not out of bounds and has not been visited.
                if (isCoOrdinatesInBounds(nx,ny)
                        && !points[nx][ny].hasBeenVisited()) {
                    pathStack.add(currentPoint);
                    // Cell is valid
                    currentPoint.removeState(dir.state);

                    Point nextPoint = getPoint(nx, ny);
                    nextPoint.removeState(dir.opposite.state);
                    nextPoint.setVisited();
                    pathStack.add(nextPoint);
                }
            }
        }

    }
}
