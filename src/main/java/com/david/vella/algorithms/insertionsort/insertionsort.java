package com.david.vella.algorithms.insertionsort;

public class insertionsort {
    /**
     * Best: O(n) time | O(1) space - where n is the length of the input array
     * Average: O(n^2) time | O(1) space - where n is the length of the input array
     * Worst: O(n^2) time | O(1) space - where n is the length of the input array
     * Is like if sorting card in the hand
     */
    public static int[] insertionSort(int[] array) {
        int[] sortedArray = array.clone();
        for (int j = 1; j < sortedArray.length; j++) {
            int key = sortedArray[j];
            int index = j - 1;
            while (index >= 0 && sortedArray[index] > key) {
                sortedArray[index + 1] = sortedArray[index];
                index--;
            }
            sortedArray[index + 1] = key;
        }
        return sortedArray;
    }
}
