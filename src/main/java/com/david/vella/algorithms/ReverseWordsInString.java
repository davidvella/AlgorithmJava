package com.david.vella.algorithms;

import java.util.*;

public class ReverseWordsInString {

    /**
     * Given an input string s, reverse the order of the words.
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     * Return a string of the words in reverse order concatenated by a single space.
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     */
    public static String reverseWordsInString(String string) {
        int off = 0;
        int next;
        ArrayList<String> words = new ArrayList<>();
        // Keep on looping until there are no more matching characters
        while ((next = string.indexOf(' ', off)) != -1) {
            String res = string.substring(off, next);
            if(!res.isEmpty()) words.add(res);
            off = next + 1;
        }
        // Add the remaining segment
        words.add(string.substring(off));

        StringBuilder sb = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            sb.append(words.get(i) + " ");
        }
        return trimSubstring(sb);
    }

    public static String trimSubstring(StringBuilder sb) {
        int first, last;

        for (first=0; first<sb.length(); first++)
            if (!Character.isWhitespace(sb.charAt(first)))
                break;

        for (last=sb.length(); last>first; last--)
            if (!Character.isWhitespace(sb.charAt(last-1)))
                break;

        return sb.substring(first, last);
    }

}

