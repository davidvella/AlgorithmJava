package com.david.vella.algorithms.travellingsalesman;

import lombok.EqualsAndHashCode;

import java.util.*;

public class ShortestPathVisitingAllNodes {
    /**
     * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
     *
     * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
     *
     * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
     * Example 1:
     * Input: [[1,2,3],[0],[0],[0]]
     * Output: 4
     * Explanation: One possible path is [1,0,2,0,3]
     *
     * Example 2:
     * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
     * Output: 4
     * Explanation: One possible path is [0,1,4,2,3]
     *
     * Note:
     * 1 <= graph.length <= 12
     * 0 <= graph[i].length < graph.length
     */
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;

        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        // Create a queue of all nodes
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1<<i);
            queue.offer(node);
            visited.add(node.toString());
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // If all nodes have been visited
                if (node.bitSet == fullMask) return level;
                // For each in adjacency list
                for (int next : graph[node.id]) {
                    // Set new node with set of path
                    Node nextNode = new Node(next, node.bitSet | (1 << next));
                    if (visited.contains(nextNode.toString())) continue;
                    queue.offer(nextNode);
                    visited.add(nextNode.toString());
                }
            }
            level++;
        }

        return level;
    }

    static class Node {
        int id;
        int bitSet;

        Node(int id, int mask){
            this.id = id;
            this.bitSet = mask;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Node)) return false;
            Node other = (Node) o;
            if (!other.canEqual((Object)this)) return false;
            if (!super.equals(o)) return false;
            if (this.id != other.id) return false;
            if (this.bitSet != other.bitSet) return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = (result*PRIME) + super.hashCode();
            result = (result*PRIME) + this.id;
            result = (result*PRIME) + this.bitSet;
            return result;
        }

        protected boolean canEqual(Object other) {
            return other instanceof Node;
        }

        public String toString() {
            return id + " " + bitSet;
        }
    }
}
