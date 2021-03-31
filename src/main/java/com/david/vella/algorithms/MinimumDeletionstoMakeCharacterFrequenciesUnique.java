package com.david.vella.algorithms;

import java.util.HashSet;

/**
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string. For example,
 * in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        //Create a bucket to store the frequencies of all characters
        int[] bucket = new int[26];
        int res = 0;

        /**
         * The letters A-Z in their uppercase ('\u0041' through '\u005A'), lowercase ('\u0061' through '\u007A'),
         * and full width variant ('\uFF21' through '\uFF3A' and '\uFF41' through '\uFF5A') forms have numeric values from 10 through 35.
         * This is independent of the Unicode specification, which does not assign numeric values to these char values.
         * To get 0 - 25 we just subtract a
         */
        for (int i = 0; i < s.length(); ++i)
            ++bucket[s.charAt(i) - 'a'];

        // Create a set to store if a certain frequency is present
        HashSet<Integer> used = new HashSet<>();
        for(int i=0;i<bucket.length;i++) {
            int freq = bucket[i];
            // Keep on looping until nothing is left
            while (freq > 0) {
                if (!used.contains(freq)) {
                    used.add(freq);
                    break;
                }
                freq--;
                res++;
            }
        }
        return res;
    }
}
