package com.david.vella.algorithms.maze;

import java.util.List;

public interface MazeSolver {
    /*
     ** Finds path between two nodes or returns null
     **
     ** @param start coordinates of the start position
     ** @param end coordinates of the end position
     ** @return (List<Point> | null) the path
     */
    List<Point> findPathTo(Point start, Point end);
}
