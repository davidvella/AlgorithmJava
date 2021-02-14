package com.david.vella.algorithms.bfs;

import com.david.vella.algorithms.maze.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BreadthFirstSearch implements MazeSolver {
    // construct a set to keep track of visited cells
    private Set<Point> visited;
    //  maintain a queue of paths
    private Queue<Point> queue;

    private final Maze maze;

    BreadthFirstSearch(Maze abstractMaze) {
        // construct a set to keep track of visited cells
        this.visited = new HashSet<>();
        //  maintain a queue of paths
        this.queue = new LinkedList<>();
        this.maze = abstractMaze;
    }

    public static void main(String[] args) {
        // Get a maze
        IterativeBackTrackingMaze maze = new IterativeBackTrackingMaze(100, 100);
        var start = maze.getStart();
        var end = maze.getEnd();

        BreadthFirstSearch search = new BreadthFirstSearch(maze);
        var path = search.findPathTo(start, end);
        System.out.println(path.size());
    }

    /*
     ** Finds path between two nodes or returns null
     **
     ** @param start coordinates of the start position
     ** @param end coordinates of the end position
     ** @return (List<Point> | null) the path
     */
    @Override
    public List<Point> findPathTo(Point start, Point end) {
        // push the first path into the queue
        queue.add(start);

        Stack<Point> pathStack = new Stack();
        pathStack.add(start);


        // loop till queue is empty
        while (!queue.isEmpty()) {
            var currentNode = queue.remove();

            for (var neighbour: currentNode.getAdjacencyList(maze)) {
                if(!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                    pathStack.add(neighbour);
                    if(neighbour == end) break;
                }
            }
        }

        // Find the shortest path
        Point node, currentSrc=end;

        ArrayList<Point> shortestPathList = new ArrayList();
        shortestPathList.add(end);
        while(!pathStack.isEmpty())
        {
            node = pathStack.pop();
            if(node.isNeighbour(currentSrc, maze))
            {
                shortestPathList.add(node);
                currentSrc = node;
                if(node == start)
                    break;
            }
        }
        Collections.reverse(shortestPathList);
        return shortestPathList;
    }
}
