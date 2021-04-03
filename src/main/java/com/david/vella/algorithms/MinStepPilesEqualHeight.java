package com.david.vella.algorithms;

import java.util.Arrays;

/**
 * Alexa is given n piles of equal or unequal heights. In one step,
 * Alexa can remove any number of boxes from the pile which has the maximum height and
 * try to make it equal to the one which is just lower than the maximum height of the stack.
 *
 * Determine the minimum number of steps required to make all of the piles equal in height.
 *
 * Example 1:
 *
 * Input: piles = [5, 2, 1]
 * Output: 3
 * Explanation:
 *
 * Step 1: reducing 5 -> 2 [2, 2, 1]
 * Step 2: reducing 2 -> 1 [2, 1, 1]
 * Step 3: reducing 2 -> 1 [1, 1, 1]
 * So final number of steps required is 3.
 *
 * {5,2,1})  Expected: 3
 * {5,5,2,2,1,1} Expected: 6
 * {5,5,1} Expected: 2
 * {5,5,5,5,1} Expected: 4
 * {3,2,2} Expected: 1
 */
public class MinStepPilesEqualHeight {

    /**
     * Time complexity: O(NlogN)
     * Space complexity: O(1)
     */
    public static int minSteps(int[] piles){
        int len = piles.length;
        if(len <= 1) return 0;
        // Sort in n log n
        Arrays.sort(piles);
        // We just need to sort the array and record how many different numbers appeared before and sum them up.
        int res = 0, distinctNums = 0;
        for(int i = 1; i < len; ++i){
            if (piles[i] != piles[i - 1]) {
                ++distinctNums;
            }
            res += distinctNums;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testcases = {{5, 2, 1},  {5,5,2,2,1,1}};
        for(int[] testcase: testcases)
            System.out.println(minSteps(testcase));
    }
}
