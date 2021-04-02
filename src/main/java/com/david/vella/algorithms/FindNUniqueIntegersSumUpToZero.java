package com.david.vella.algorithms;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 *
 */
public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        /**
         * Another idea based on properties of the sequence
         * Find the rule
         * A[i] = i * 2 - n + 1
         * Math Observation
         * Actually, this rule could be derived from constructing an arithmetic sequence.
         * (Note that any arithmetic sequence must have unique values if the common delta is non-zero)
         * We need the sequence sum, so that
         * (a[0] + a[n-1]) * n / 2 = 0, which means a[0] + a[n-1] = 0.
         * Note that a[n-1] - a[0] = (n-1) * delta, which is -2 * a[0],
         * so we simply set delta = 2, a[0] = 1 - n
         */
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = i * 2 - n + 1;
        }
        return res;
    }
}
