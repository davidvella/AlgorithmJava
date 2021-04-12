package com.david.vella.algorithms;

/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Example 2:
 *
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 */
public class LongestCommonSubsequence {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // #1 Calculate the longest common subsequence
        // // dp[row][col] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1+1][len2+1];
        for (int row=1; row<=len1; row++) {
            for (int col=1; col<=len2; col++) {
                dp[row][col] = word1.charAt(row-1) == word2.charAt(col-1)
                        ? dp[row][col] = dp[row-1][col-1] + 1
                        : Math.max(dp[row-1][col], dp[row][col-1]);
            }
        }
        int maxSubseq = dp[len1][len2];

        // #2 Calculate the required steps
        return word1.length() + word2.length() - 2 * maxSubseq;
    }
}
