package com.david.vella.algorithms;

import java.util.*;

public class TypoSquatting {
    // Char to check dots
    private static final char DOT_CHAR = '.';

    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains){
        Set<String> companySet = new HashSet<>(companyDomains);
        Set<String> res = new HashSet<>();
        // For each domain check against list of valid domains
        for (String newDomain:
                newDomains) {
            // Check new domain matches company domain. No need to add twice
            for (String companyDomain:
                    companyDomains) {
                // Make sure both domains are not null
                if(companyDomain != null && newDomain != null){
                    // Check each rule and add to list if match
                    if(isFirstDotSwapTypoSquat(companyDomain, newDomain)
                            || isLevenshteinDistanceTypoSquat(companyDomain, newDomain)){
                        res.add(newDomain);
                        break;
                    }
                }
            }
        }
        res.removeAll(companySet);
        List<String> targetList = new ArrayList<>(res);
        return targetList;
    }

    /**
     * Check whether there was a swap which occurred in the first dot in the domain
     */
    public static boolean isFirstDotSwapTypoSquat(String original, String str2){
        int originalIndex = 0, str2Index = 0;
        // We need to confirm a dot has been set and if no dots have been set
        boolean str2dot = false;
        try{
            Character originalChar;
            Character str2Char;
            // Loop until reach Dot Char if no dot char through error. Should break on first dot
            while ((originalChar = Character.toLowerCase(original.charAt(originalIndex))) != DOT_CHAR) {
                str2Char = Character.toLowerCase(str2.charAt(str2Index));
                // same go to next
                if(originalChar == str2Char) {
                    originalIndex++;
                    str2Index++;
                }
                // Take into account multiple dots
                else if(str2Char.equals(DOT_CHAR) && original.charAt(originalIndex + 1) == DOT_CHAR){
                    // Go to next char to check if is equal
                    str2Index++;
                    str2dot = true;
                }
                else {
                    // Characters don't match or more than one dot
                    return false;
                }
            }
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            // If there is no dot then return false or reached end of string
            return false;
        }
        // We have seen a dot in String 2
        return str2dot;
    }

    /**
     * Check whether the domain is a typosquatt by checking the Levenshtein Distance
     */
    public static boolean isLevenshteinDistanceTypoSquat(String original, String str2){
        // check all characters are the same so we only check swaps on levenshtein distance
        if(!isAnagram(original,str2)) return false;

        final int distance = levenshteinDistance(original,str2);
        return distance <= 2 && distance > 0;
    }

    /**
     * Check whether two strings are anagrams
     */
    public static boolean isAnagram(String s, String s2) {
        //Time complexity : O(n log n)
        if (s.length() != s2.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * Returns the Levenshtein Distance between two strings.
     * The Levenshtein distance is a string metric for measuring the difference between two sequences.
     * @param original The string of origin
     * @param str2 The altered string
     * @return The Levenshtein distance
     */
    // O(nm) time | O(nm) space
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

    public static void main(String[] args) {
        List<String> companyDomains = Arrays.asList("palantir.com");
        List<String> domains = Arrays.asList("prlanti.acom","plaantir.com","palanti.rbiz","","palanti.abiz","palantircom","palanti");
        List<String> res = typosquats(companyDomains,domains);
    }
}
