package com.david.vella.algorithms;

public class LevenshteinDistance {

    /**
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     *
     * You have the following three operations permitted on a word:
     *
     * Insert a character
     * Delete a character
     * Replace a character
     */
    public static int levenshteinDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // For the base case, that is, to convert a string to an empty string, the minimum number of operations
        // (deletions) is just the length of the string. So we have dp[i][0] = i and dp[0][j] = j.
        for(int i = 0; i <= m; i++)
            dp[i][0] = i;
        for(int i = 1; i <= n; i++)
            dp[0][i] = i;

        // For the general case to convert word1[0..i) to word2[0..j), we break this problem down into sub-problems.
        // Suppose we have already known how to convert word1[0..i - 1) to word2[0..j - 1) (dp[i - 1][j - 1]),
        // if word1[i - 1] == word2[j - 1], then no more operation is needed and dp[i][j] = dp[i - 1][j - 1].
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                /**
                 * If word1[i - 1] != word2[j - 1], we need to consider three cases.
                 *
                 * Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
                 * If word1[0..i - 1) = word2[0..j) then delete word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
                 * If word1[0..i) + word2[j - 1] = word2[0..j) then insert word2[j - 1] to word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).
                 * So when word1[i - 1] != word2[j - 1], dp[i][j] will just be the minimum of the above three cases.
                 */
                if(str1.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else {
                    int a = dp[i][j];
                    int b = dp[i][j + 1];
                    int c = dp[i + 1][j];
                    dp[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    dp[i + 1][j + 1]++;
                }
            }
        }
        return dp[m][n];
    }
}
