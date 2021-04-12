package com.david.vella.algorithms;

import java.util.BitSet;

public class CodilityTest {

    /**
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     *
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     *
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     *
     * Given A = [1, 2, 3], the function should return 4.
     *
     * Given A = [−1, −3], the function should return 1.
     *
     * Write an efficient algorithm for the following assumptions:
     *
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     */
    public int solution(int[] A) {
        int n = A.length;

        // To mark the occurrence of elements
        BitSet present = new BitSet(n +1);

        // Mark the occurrences
        for (int i = 0; i < n; i++) {

            // Only mark the required elements
            // All non-positive elements and
            // the elements greater n + 1 will never
            // be the answer
            // For example, the array will be {1, 2, 3}
            // in the worst case and the result
            // will be 4 which is n + 1
            if (A[i] > 0 && A[i] <= n)
                present.set(A[i]);
        }

        // Find the first element which didn't
        // appear in the original array
        for (int i = 1; i <= n; i++)
            if (!present.get(i))
                return i;

        // If the original array was of the
        // type {1, 2, 3} in its sorted form
        return n + 1;
    }
}
