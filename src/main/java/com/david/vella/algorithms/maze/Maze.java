package com.david.vella.algorithms.maze;

public interface Maze {
    /**
     * Generate Maze
     */
    void generateMaze();

    boolean isCoOrdinatesInBounds(int x, int y);

    boolean isInBounds(int v, int upper);

    void print();

    Point getPoint(int x, int y);

    Point getStart();

    Point getEnd();

    int getWidth();

    int getHeight();
}
