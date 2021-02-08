package com.david.vella.algorithms.maze;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

/**
 * Inspired by http://weblog.jamisbuck.org/2011/1/3/maze-generation-kruskal-s-algorithm
 *
 * Throw all of the edges in the graph into a big burlap sack. (Or, you know, a set or something.)
 * Pull out the edge with the lowest weight. If the edge connects two disjoint trees, join the trees. Otherwise, throw that edge away.
 * Repeat until there are no more edges left.
 */
public class KruskalMaze extends AbstractMaze{

    private List<List<Tree>> sets;
    private Stack<Edge> edges;
    private Random random;

    /**
     * Create a new maze of size and width
     *
     * @param width  Width of the maze
     * @param height Height of the maze
     */
    public KruskalMaze(int width, int height) {
        super(width, height);
    }

    void init(){
        random = new Random();

        // Initialize the sets to the same dimension as the maze.
        // We use Tree objects to represent the sets to be joined.
        this.sets = new ArrayList<>();
        for ( int y=0; y < height; ++y ) {
            List<Tree> tmp = new ArrayList<>();
            for ( int x=0; x < width; ++x ) {
                tmp.add(new Tree());
            }
            sets.add(tmp);
        }

        // Build the collection of edges and randomize.
        // Edges are "north" and "west" sides of cell,
        // if index is greater than 0.
        this.edges = new Stack<>();
        for ( int y=0; y < height; ++y ) {
            for (int x=0; x < width; ++x ) {
                if ( y > 0 ) 	{ edges.add(new Edge(x,y,MazePassageDirection.North)); }
                if ( x > 0 ) 	{ edges.add(new Edge(x,y,MazePassageDirection.West)); }
            }
        }
        Collections.shuffle(edges);

        addWallsToAllPoints();
    }

    @Override
    void generateMaze() {
        init();
        while (!edges.isEmpty()) {
            // Select the next edge, and decide which direction we are going in.
            Edge tmp = edges.pop();
            int cx = tmp.getX();
            int cy = tmp.getY();

            MazePassageDirection direction = tmp.getDirection();
            int nx = cx + direction.directionX;
            int ny = cy + direction.directionY;

            // Pluck out the corresponding sets
            Tree set1 = (sets.get(cy)).get(cx);
            Tree set2 = (sets.get(ny)).get(nx);

            if ( !set1.connected(set2) ) {
                // Connect the two sets and "knock down" the wall between them.
                set1.connect(set2);
                points[cx][cy].removeState(direction.state);
                points[nx][ny].removeState(direction.opposite.state);
            }
        }
    }

    /***********************************************************************
     * We will use a tree structure to model the "set" (or "vertex")
     * that is used in Kruskal to build the graph.
     *
     ***********************************************************************/
    class Tree {

        private Tree _parent = null;

        //
        // Build a new tree object
        //
        public Tree() {

        }

        //
        // If we are joined, return the root. Otherwise, return this object instance.
        //
        public Tree root() {
            return _parent != null ? _parent.root() : this;
        }

        //
        // Are we connected to this tree?
        //
        public boolean connected(Tree tree) {
            return this.root() == tree.root();
        }

        //
        // Connect to the tree
        //
        public void connect(Tree tree) {
            tree.root().setParent(this);
        }

        //
        // Set the parent of the object instance
        public void setParent(Tree parent) {
            this._parent = parent;
        }
    }

    /**
     * Encapsulates the x,y coord of where the edge starts, and the direction in which it points.
     */
    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    class Edge {
        private int x;
        private int y;
        private MazePassageDirection direction;
    }
}
