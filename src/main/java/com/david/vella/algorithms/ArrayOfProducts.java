package com.david.vella.algorithms;

public class ArrayOfProducts {
    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * O(n) time | O(n) space - where n is the length of the input array
     */
    public int[] arrayOfProducts(int[] array) {
        int n = array.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * array[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * array[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
