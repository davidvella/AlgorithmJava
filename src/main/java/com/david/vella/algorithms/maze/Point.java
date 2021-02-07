package com.david.vella.algorithms.maze;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Point {

    /**
     * Value which holds the state of the object
     */
    @Setter
    @ToString.Exclude
    private int state = 0;

    /**
     * The x-coordinate of the new Point structure.
     */
    @Getter
    private final int x;

    /**
     * The y-coordinate of the new Point structure.
     */
    @Getter
    private final int y;

    /**
     * Enum which contains the numbers used to calculate the state of a point
     */
    @AllArgsConstructor
    enum PointState
    {
        WallNorth(1),
        WallSouth(2),
        WallEast(4),
        WallWest(8),
        Visited(128);

        private int ordinal;
    }

    /**
     * @return Whether this point in Maze has a North Wall
     */
    public boolean hasNorthWall(){
        return hasState(PointState.WallNorth);
    }

    /**
     * @return Whether this point in Maze has a South Wall
     */
    public boolean hasSouthWall(){
        return hasState(PointState.WallSouth);
    }

    /**
     * @return Whether this point in Maze has a East Wall
     */
    public boolean hasEastWall(){
        return hasState(PointState.WallEast);
    }

    /**
     * @return Whether this point in Maze has a West Wall
     */
    public boolean hasWestWall(){
        return hasState(PointState.WallWest);
    }

    /**
     * Return a list of points that the user can travel to next.
     * @return A list of available points.
     */
    public List<Point> getAdjacencyList(AbstractMaze maze){
        List<Point> availablePoints = new ArrayList<>(4);

        // Check each direction
        if(!hasNorthWall()){
            availablePoints.add(maze.getPoint(x + MazePassageDirection.North.directionX, y + MazePassageDirection.North.directionY));
        }
        // Check each direction
        if(!hasSouthWall()){
            availablePoints.add(maze.getPoint(x + MazePassageDirection.South.directionX, y + MazePassageDirection.South.directionY));
        }
        // Check each direction
        if(!hasEastWall()){
            availablePoints.add(maze.getPoint(x + MazePassageDirection.East.directionX, y + MazePassageDirection.East.directionY));
        }
        // Check each direction
        if(!hasWestWall()){
            availablePoints.add(maze.getPoint(x + MazePassageDirection.West.directionX, y + MazePassageDirection.West.directionY));
        }

        return availablePoints;
    }

    /**
     * Check whether point is neighbour of this point.
     */
    public boolean isNeighbour(Point point, AbstractMaze maze){
        return getAdjacencyList(maze).stream().anyMatch((adjacent) -> adjacent.equals(point));
    }

    /**
     * Set the state to visited. Is used when generate the maze.
     */
    void setVisited(){
        appendState(PointState.Visited);
    }

    /**
     * Append the state value
     * @param newState The state value to be added to the State
     */
    void appendState(PointState newState){
        state |= newState.ordinal;
    }

    /**
     * Append the state value
     * @param oldState The state value to be removed from the State
     */
    void removeState(PointState oldState){
        this.state &= ~oldState.ordinal;
    }

    /**
     * Append the state value
     * @param checkState Whether the state value has been set.
     */
    boolean hasState(PointState checkState){
        return (this.state & checkState.ordinal) == checkState.ordinal;
    }

    /**
     * Append the visited state value has been set
     */
    boolean hasBeenVisited(){
        return hasState(PointState.Visited);
    }


}
