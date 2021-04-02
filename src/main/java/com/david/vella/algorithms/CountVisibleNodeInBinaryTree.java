package com.david.vella.algorithms;

/**
 * In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s, this node A is visible. We need to count the number of visible nodes in a binary tree.
 *
 * Example 1:
 *
 * Input:
 *         5
 *      /     \
 *    3        10
 *   /  \     /
 * 20   21   1
 *
 * Output: 4
 * Explanation: There are 4 visible nodes: 5, 20, 21, and 10.
 *
 * Example 2:
 *
 * Input:
 *   -10
 * 	\
 * 	-15
 * 	   \
 * 	   -1
 *
 * Output: 2
 * Explanation: Visible nodes are -10 and -1.
 */
public class CountVisibleNodeInBinaryTree {

  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    int goodNodes(TreeNode root) {
        return countVisibleNodes(root, Integer.MIN_VALUE);
    }

    // Time: O(n)
    // Space: O(n)
    static int countVisibleNodes(TreeNode node, int maxSoFar) {
        int count = 0;

        if(node == null) return count;

        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }
        return count + countVisibleNodes(node.left, maxSoFar) + countVisibleNodes(node.right, maxSoFar);
    }

}
