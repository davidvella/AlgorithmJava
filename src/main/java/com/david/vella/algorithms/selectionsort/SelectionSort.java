package com.david.vella.algorithms.selectionsort;

public class SelectionSort {

    /**
     * Best: O(n^2) time | O(1) space - where n is the length of the input array
     * Average: O(n^2) time | O(1) space - where n is the length of the input array
     * Worst: O(n^2) time | O(1) space - where n is the length of the input array
     */
    public static int[] selectionSort(int[] array) {
        int[] clone = array.clone();
        for (int startIndex = 0; startIndex < clone.length - 1; startIndex++){
            int smallestIndex = startIndex;
            for (int i = startIndex + 1; i < clone.length; i++){
                if(clone[smallestIndex] > clone[i]) {
                    smallestIndex = i;
                }
            }
            swap(clone, smallestIndex, startIndex);
        }
        return clone;
    }

    private static void swap(int[]array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
