package com.david.vella.algorithms.bfs;

import com.david.vella.algorithms.maze.IterativeBackTrackingMaze;
import com.david.vella.algorithms.maze.Point;
import com.david.vella.algorithms.maze.RecursiveBackTrackingMaze;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class BreadthFirstSearch {

    public static void main(String[] args) {
        // Get a maze
        IterativeBackTrackingMaze maze = new IterativeBackTrackingMaze(1000, 1000);
        var start = maze.getStart();
        var end = maze.getEnd();
        ArrayList<Point> shortestPathList = new ArrayList();

        // construct a set to keep track of visited cells
        Set<Point> visited = new HashSet<>();
        //  maintain a queue of paths
        Queue<Point> queue = new LinkedList<>();
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
        System.out.println(shortestPathList.size());
    }
}
