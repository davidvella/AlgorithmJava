package com.david.vella.algorithms;

public class PalindromeChecker {

    /**
     * O(n/2) time | O(1) space - where n is the length of the input string
     */
    public static boolean isPalindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }
        int head = 0, tail = str.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = str.charAt(head);
            cTail = str.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
