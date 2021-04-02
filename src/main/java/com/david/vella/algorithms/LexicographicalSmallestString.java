package com.david.vella.algorithms;

/**
 * Lexicographically smallest string formed by removing at most one character.
 * Example 1:
 * Input: "abczd"
 * Output: "abcd"
 *
 *   Result: ("bba") Expected: ba
 *   Result: ("abczd") Expected: abcd
 *   Result: ("abcdz") Expected: abcd
 *
 */
public class LexicographicalSmallestString {

    /**
     *  By definition of lexicographical order each next string is larger
     *  than the previous one А < АА < ААА < АAB < ААC < АB < B < … < ZZZ
     *  Since we could only remove one character, we should remove the first char
     *  we meet that is greater than the next from left to right.
     *  In this case our string will be lexicographically smallest.
     *
     *  Big O time(n) size(n)
     */
    static String solution(String str){
        int s_size = str.length();

        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < s_size - 1; ++i) {
            // To handle duplicate value values
            if (str.charAt(i) > str.charAt(i + 1)) {
                stringBuilder.deleteCharAt(i);
                break;
            }
        }
        return stringBuilder.toString();
    }
}
