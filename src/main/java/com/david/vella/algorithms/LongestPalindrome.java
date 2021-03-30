package com.david.vella.algorithms;

public class LongestPalindrome {

    /**
     * Given a string s, return the longest palindromic substring in s.
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * Example 3:
     *
     * Input: s = "a"
     * Output: "a"
     * Example 4:
     *
     * Input: s = "ac"
     * Output: "a"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters (lower-case and/or upper-case),
     */
    public static String longestPalindromicSubstring(String str) {
        if (str == null || str.length() <= 1)
            return str;
        int len = str.length();
        // dp[i][j] stands for status of a substring starting at i and ending at j incl j
        boolean[][] dp = new boolean[len][len];

        // initialize all the 1 character palins
        for(int i = 0; i < len; i++)
            dp[i][i] = true;

        // to compute dp[i][j] we need dp[i+1][j-1]
        // so the i - outer loop needs to go from higher to lower
        // and the j - inner loop needs to go from lower to higher
        int maxLen = 0, maxSta = 0, maxEnd = 0;
        for(int i = len; i >= 0; i--){
            // dist of 0 - already covered by initialization
            for(int dist = 1; dist < len - i; dist++){
                int j = i + dist;
                // we are ready to compute dp [i] [j]
                final boolean b = str.charAt(i) == str.charAt(j);
                if (dist == 1 && b){
                    dp[i][j] = true;
                } else if (b){
                    dp[i][j] = dp[i+1][j-1];
                }
                // if true
                if (dp[i][j] && maxLen < (j-i+1)){
                    maxLen = j - i + 1;
                    maxSta = i;
                    maxEnd = j;
                }
            }
        }
        return str.substring(maxSta,maxEnd+1);
    }
}
