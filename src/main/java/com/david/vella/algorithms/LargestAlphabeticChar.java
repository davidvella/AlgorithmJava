package com.david.vella.algorithms;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, find the largest alphabetic character, whose both uppercase and lowercase appear in S.
 * The uppercase character should be returned. For example, for S = "admeDCAB", return "D".
 * If there is no such character, return "NO".
 */
public class LargestAlphabeticChar {

    public static void main(String[] args) {
        String test = solution("admeDCAB");
    }

    public static String solution(String s){
        // 0 is ASCII is null
        char maxChar = 0;
        String res = "NO";

        Set<Character> upper = new HashSet<>();

        // To hold lower case
        BitSet char_bits = new BitSet(26);
        for (int i = 0; i < s.length() - 1; ++i) {
            char character = s.charAt(i);
            if(Character.isUpperCase(character)){
                upper.add(character);
            }
            else{
                // Set Bit set of visited lower case characters;
                char_bits.set(character - 'a');
            }
        }

        for (char upperChar:
             upper) {
            if(char_bits.get(Character.toLowerCase(upperChar) - 'a')){
                maxChar = (char)Math.max(upperChar, maxChar);
            }
        }

        // If value is not null then set value;
        if(maxChar != 0){
            res = String.valueOf(maxChar);
        }
        return res;
    }
}
