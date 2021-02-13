package com.david.vella.algorithms.astar;

import com.david.vella.algorithms.maze.AbstractMaze;
import com.david.vella.algorithms.maze.IterativeBackTrackingMaze;
import com.david.vella.algorithms.maze.MazeSolver;
import com.david.vella.algorithms.maze.Point;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class AStar implements MazeSolver {

    private Queue<Node> open;
    private Set<Node> closed;

    private Point end;

    private final AbstractMaze maze;

    public AStar(AbstractMaze abstractMaze) {
        this.open = new PriorityQueue<>();
        this.closed = new HashSet<>();
        this.maze = abstractMaze;
    }

    public static void main(String[] args) {
        IterativeBackTrackingMaze maze = new IterativeBackTrackingMaze(2000, 2000);
        var start = maze.getStart();
        var end = maze.getEnd();
        AStar search = new AStar(maze);
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
    public List<Point> findPathTo(Point start, Point end) {
        this.end = end;

        Node now = new Node(null, start, 0, 0);
        this.closed.add(now);

        addNeighboursToOpenList(now);
        while (!open.isEmpty()) {
            if (now.getPoint() == end) { // Nothing to examine
                break;
            }
            now = this.open.remove(); // get first node (lowest f score)
            this.closed.add(now); // and add to the closed
            addNeighboursToOpenList(now);
        }

        Stack<Point> path = new Stack<>();
        path.add(now.getPoint());
        while (now.getPoint() != start) {
            now = now.parent;
            path.add(now.getPoint());
        }
        return new ArrayList(path);
    }

    private void addNeighboursToOpenList(Node now) {
        for (Point neighbour:
                now.getPoint().getAdjacencyList(maze)) {
            Node node = new Node(now, neighbour, now.getG(), this.distance(neighbour));
            if (!this.open.contains(node) && !closed.contains(node)) { // if not already done
                node.g = node.parent.g + 1; // Horizontal/vertical cost = 1.0
                this.open.add(node);
            }
        }
    }

    /*
     ** Calculate distance between point and the end
     **
     ** @return (int) distance
     */
    private double distance(Point point) {
        return Math.abs(point.getX()  - this.end.getX()) + Math.abs(point.getY()  - this.end.getY());
    }

    @AllArgsConstructor
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    static class Node implements Comparable {
        @Getter
        private Node parent;
        @Getter
        @EqualsAndHashCode.Include
        private Point point;
        @Getter @Setter
        // g(n) is the cost of the path from the current node to n
        // h(n) is a heuristic function that estimates the cost of the cheapest path from n to the goal
        private double g, h;
        // Compare by f value (g + h)
        @Override
        public int compareTo(Object o) {
            Node that = (Node) o;
            Double cost = this.g + this.h;
            return cost.compareTo(that.g + that.h);
        }
    }









}
