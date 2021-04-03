package com.david.vella.algorithms;

/**
 * Given a string s and an array of integers cost where cost[i] is the cost of deleting the ith character in s.
 *
 * Return the minimum cost of deletions such that there are no two identical letters next to each other.
 *
 * Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
 *
 * Example 1:
 *
 * Input: s = "abaac", cost = [1,2,3,4,5]
 * Output: 3
 * Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
 * Example 2:
 *
 * Input: s = "abc", cost = [1,2,3]
 * Output: 0
 * Explanation: You don't need to delete any character because there are no identical letters next to each other.
 * Example 3:
 *
 * Input: s = "aabaa", cost = [1,2,3,4,1]
 * Output: 2
 * Explanation: Delete the first and the last character, getting the string ("aba").
 *
 *
 */
public class MinCostToAvoidRepeatingLetters {

    /**
     * Time O(N)
     * Space O(1)
     */
    public static int minCost(String s, int[] cost) {
        int res = 0;
        int maxCost = 0;
        for (int i = 0; i < s.length(); ++i) {
            // If value isn't same then reset cost
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                maxCost = 0;
            }
            res += Math.min(maxCost, cost[i]);
            maxCost = Math.max(maxCost, cost[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "aabaa";
        int[] testArr = {1,2,3,4,1};
        int cost = minCost(test,testArr);
    }
}
