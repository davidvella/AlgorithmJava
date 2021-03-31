package com.david.vella.algorithms;

/**
 * Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
 *
 * Example 1:
 * Input: "mamad"
 * Output: 3
 *
 * Example 2:
 * Input: "asflkj"
 * Output: -1
 *
 * Example 3:
 * Input: "aabb"
 * Output: 2
 *
 * Example 4:
 * Input: "ntiin"
 * Output: 1
 * Explanation: swap 't' with 'i' => "nitin"
 */
public class MinAdjStepsToMakePalindrome {

    private static int getNoOfSwaps(String s) {
        if(s == null || s.length() == 0) return -1;
        int totalSwaps = 0;

        if(isShuffledPalindrome(s)) {
            char[] chars = s.toCharArray();
            int start = 0, end = chars.length - 1;

            while(end > start) {
                // if we found different chars
                if (chars[start] != chars[end]) {
                    int i = end; // make an additional iterator from the end

                    // move toward the start until we found the same char
                    while (i > start && chars[i] != chars[start]) { --i; }

                    // if we scanned whole the string and found
                    // no one the same char swap char on the start with adjacent char
                    // it needs for case when the first char is not on it's right place
                    // all other parts of the algorithm don't process a char on the start
                    if (i == start) {
                        swap(chars, start, start + 1);
                        ++totalSwaps;
                    }
                    // if the same character found swap all chars from i to the end
                    else {
                        while (i < end) {
                            swap(chars,i, i + 1);
                            ++totalSwaps;
                            ++i;
                        }
                        ++start; --end;
                    }
                }
                else {
                    ++start; --end;
                }
            }
            return totalSwaps;
        }
        else return -1;
    }

    private static void swap(char[] chars, int k, int i) {
        char temp = chars[k];
        chars[k] = chars[i];
        chars[i] = temp;
    }

    private static boolean isShuffledPalindrome(String s) {
        int [] occurrence = new int[26];
        int oddCount = 0;

        for (int i = 0; i < s.length(); ++i)
            ++occurrence[s.charAt(i) - 'a'];

        for (int value : occurrence) if (value % 2 != 0) oddCount++;
        return oddCount <= 1;
    }
}
