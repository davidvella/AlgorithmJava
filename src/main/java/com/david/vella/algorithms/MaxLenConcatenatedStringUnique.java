package com.david.vella.algorithms;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static com.david.vella.algorithms.ReverseWordsInString.reverseWordsInString;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
public class MaxLenConcatenatedStringUnique {

    public static void main(String[] args) {
        List<String> arg = List.of("ab","cd","cde","cdef","efg","fgh","abxyz");
        int test = maxLength(arg);
        int result = 11;
    }


    public static int maxLength(List<String> arr) {
        // We will keep in this vector bitmaps of used letters
        // for the processed words.
        // Add one empty bitset for comparison with the first
        // processed word. It makes the algorithm a bit shorter
        List<BitSet> char_bits_list = new ArrayList<>();
        char_bits_list.add(new BitSet(26));

        int result = 0;

        // for each string in the vector make a bitset where all
        // bits corresponding to characters in alphabet are set.
        for (String str:
                arr) {
            BitSet char_bits = new BitSet(26);

            // set bits corresponding to chars in the string.
            for (int i = 0; i < str.length(); ++i)
                char_bits.set(str.charAt(i) - 'a');

            // How many bits were set.
            int bit_num = char_bits.cardinality();
            // the string contains duplicate characters so don't process it
            if (bit_num < str.length()) continue;

            // Check if current word has common letters with already processed words
            for(int i = char_bits_list.size() - 1; i >= 0; --i){
                BitSet c_b = char_bits_list.get(i);

                // if two bitsets have common 1 bits i.e.
                // if two words have common letters don't process current word
                if (c_b.intersects(char_bits)) continue;

                // if current word has unique letters add to the vector a bitset where
                // all bits corresponding to letters of the current word are set to 1.
                BitSet temp = (BitSet) char_bits.clone();
                temp.or(c_b);
                char_bits_list.add(temp);
                // add length of the current word to the result
                result = Integer.max(result, temp.cardinality());
            }
        }
        return result;
    }
}
