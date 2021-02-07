package com.david.vella.algorithms.maze;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
/**
 * Set up constants to aid with describing the passage directions
 */
public enum MazePassageDirection {

    North( 0, -1, Point.PointState.WallNorth),
    South( 0, 1, Point.PointState.WallSouth),
    East( 1, 0, Point.PointState.WallEast),
    West( -1, 0, Point.PointState.WallWest);

    // Direction used to traverse the two dimensional array of point
    final int directionX;
    final int directionY;
    final Point.PointState state;
    MazePassageDirection opposite;

    // use the static initializer to resolve forward references
    static {
        North.opposite = South;
        South.opposite = North;
        East.opposite = West;
        West.opposite = East;
    }
};