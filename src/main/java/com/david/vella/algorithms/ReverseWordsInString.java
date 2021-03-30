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
            words.add(string.substring(off, next));
            off = next + 1;
        }
        // Add the remaining segment
        words.add(string.substring(off));
        reverse(words);
        return String.join(" ", words);
    }

    /**
     * Reverses the order of the elements in the specified list.<p>
     * <p>
     * This method runs in linear time.
     */
    public static void reverse(List<String> list) {
        int size = list.size();

        for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--)
            swap(list, i, j);
    }

    /**
     * Swaps the elements at the specified positions in the specified list.
     * (If the specified positions are equal, invoking this method leaves
     * the list unchanged.)
     *
     * @param list The list in which to swap elements.
     * @param i    the index of one element to be swapped.
     * @param j    the index of the other element to be swapped.
     */
    public static void swap(List<String> list, int i, int j) {
        final List<String> l = list;
        l.set(i, l.set(j, l.get(i)));
    }
}

