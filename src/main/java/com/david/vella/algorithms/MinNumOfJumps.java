package com.david.vella.algorithms;

import java.util.Arrays;

/**
 You're given a non-empty array of positive integers where each integer represents the
 maximum number of steps you can take forward in the array. For example, if the
 element at index 1 is 3, you can go from index 1 to index 2, 3, or 4.

 Write a function that returns the minimum number of jumps needed to reach the final index.

 Note that jumping from index i to index i + x always constitutes one jump, no matter how large x is.

 Sample Input =  [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
 Sample Output = 4
 */
public class MinNumOfJumps {

    public static int minNumberOfJumps(int[] array) {
        int[] jumps = new int[array.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for (int i = 1; i < array.length; ++i){
            for (int j = 0; j < i; j++){
                if (array[j] >= i-j){
                    jumps[i] = Math.min(jumps[j] + 1, jumps[i]);
                }
            }
        }
        return jumps[jumps.length - 1];
    }
}
