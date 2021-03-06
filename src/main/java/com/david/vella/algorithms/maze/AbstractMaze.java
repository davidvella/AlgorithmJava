package com.david.vella.algorithms.maze;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractMaze implements Maze {

    final Point[][] points;
    @Getter
    final int width;
    @Getter
    final int height;

    /**
     * Create a new maze of size and width
     * @param width Width of the maze
     * @param height Height of the maze
     */
    public AbstractMaze(int width, int height) {
        this.width = width;
        this.height = height;
        this.points = new Point[width][height];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point(i, j);
            }
        }

        generateMaze();
    }

    /**
     * Whether a co-ordinate is out of bounds of the maze
     * @param x The x co-ordinate
     * @param y The y co-ordinate
     * @return Boolean value whether co-ordinate exists in maze
     */
    @Override
    public boolean isCoOrdinatesInBounds(int x, int y){
        return isInBounds(x, width) && isInBounds(y, height);
    }

    @Override
    public boolean isInBounds(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    @Override
    public void print() {
        for (int i = 0; i < height; i++) {
            // draw the north edge
            for (int j = 0; j < width; j++) {
                System.out.print(getPoint(j,i).hasNorthWall() ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < width; j++) {
                System.out.print(getPoint(j,i).hasWestWall() ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < width; j++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }


    @Override
    public Point getPoint(int x, int y){
        return points[x][y];
    }

    @Override
    public Point getStart(){
        return getPoint(0,0);
    }

    @Override
    public Point getEnd(){
        return getPoint(ThreadLocalRandom.current().nextInt(0, getWidth() - 1),
                ThreadLocalRandom.current().nextInt(0, getHeight() - 1));
    }

    void addWallsToAllPoints(){
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j].appendState(Point.PointState.WallEast);
                points[i][j].appendState(Point.PointState.WallNorth);
                points[i][j].appendState(Point.PointState.WallSouth);
                points[i][j].appendState(Point.PointState.WallWest);
            }
        }
    }
}
