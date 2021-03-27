package com.david.vella.algorithms;

public class MonotonicArray {

    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.
     * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
     * Return true if and only if the given array A is monotonic.
     * O(n) time | O(1) space - where n is the length of the array
     */
    public static boolean isMonotonic(int[] array) {
        boolean increase = false;
        boolean decrease = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                decrease = true;
            }
            if (array[i] > array[i - 1]) {
                increase = true;
            }
        }

        return !(increase && decrease);
    }
}
