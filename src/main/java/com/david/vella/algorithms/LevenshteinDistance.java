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
    public static int levenshteinDistance(String original, String str2) {
        int ol = original.length();
        int str2l = str2.length();

        int[][] dp = new int[ol + 1][str2l + 1];

        // For the base case, that is, to convert a string to an empty string, the minimum number of operations
        // (deletions) is just the length of the string. So we have dp[i][0] = i and dp[0][j] = j.
        for(int i = 0; i <= ol; i++)
            dp[i][0] = i;
        for(int i = 1; i <= str2l; i++)
            dp[0][i] = i;

        // For the general case to convert word1[0..i) to word2[0..j), we break this problem down into sub-problems.
        // Suppose we have already known how to convert word1[0..i - 1) to word2[0..j - 1) (dp[i - 1][j - 1]),
        // if word1[i - 1] == word2[j - 1], then no more operation is needed and dp[i][j] = dp[i - 1][j - 1].
        for(int i = 0; i < ol; i++) {
            for(int j = 0; j < str2l; j++) {

                /**
                 * If word1[i - 1] != word2[j - 1], we need to consider three cases.
                 *
                 * Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1);
                 * If word1[0..i - 1) = word2[0..j) then delete word1[i - 1] (dp[i][j] = dp[i - 1][j] + 1);
                 * If word1[0..i) + word2[j - 1] = word2[0..j) then insert word2[j - 1] to word1[0..i) (dp[i][j] = dp[i][j - 1] + 1).
                 * So when word1[i - 1] != word2[j - 1], dp[i][j] will just be the minimum of the above three cases.
                 */
                if(original.charAt(i) == str2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j];
                else {
                    int replace = dp[i][j];
                    int delete = dp[i][j + 1];
                    int insert = dp[i + 1][j];
                    dp[i + 1][j + 1] = replace < delete ? (replace < insert ? replace : insert) : (delete < insert ? delete : insert);
                    dp[i + 1][j + 1]++;
                }
            }
        }
        return dp[ol][str2l];
    }

    public static double levenSteinRatio(String original, String str2){
        Integer distance = levenshteinDistance(original, str2);
        // Computation of the Levenshtein Distance Ratio
        return ((double)(original.length()+str2.length()) - distance) / (original.length()+str2.length());
    }

}
