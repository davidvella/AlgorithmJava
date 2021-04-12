package com.david.vella.algorithms;

import java.util.Stack;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * <p>
 * Each root-to-leaf path in the tree represents a number.
 * <p>
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers.
 * <p>
 * A leaf node is a node with no children.
 */
public class SumRootToLeaf {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Performance: O(|V|) V being number of vertices
     * Space: O(|V|) V being number of vertices
     */
    public int sumNumbers(TreeNode root) {
        int ret = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            TreeNode node = p.first;
            int value = p.second;
            if (node != null) {
                value = value*10 + node.val;
                if (node.left == null && node.right == null) {
                    ret += value;
                }
                stack.push(new Pair(node.right, value));
                stack.push(new Pair(node.left, value));
            }
        }
        return ret;
    }

    static class Pair<U,V>{
        //first is the current word
        //second is the priority for the priority queue
        U first;
        V second;

        Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
    }
}
