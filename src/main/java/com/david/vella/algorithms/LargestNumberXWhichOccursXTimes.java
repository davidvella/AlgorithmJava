package com.david.vella.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that, given an array A of N integers, returns the largest integer
 * K > 0 such that both values K and -K exist in array A.
 * If there is no such integer, the function should return 0.
 *
 * Example 1:
 * Input: [3, 2, -2, 5, -3]
 * Output: 3
 *
 * Example 2:
 * Input: [1, 2, 3, -4]
 * Output: 0
 *
 *  {3, 8, 2, 3, 3, 2} Expected: 3;
 *  {7, 1, 2, 8, -2} Expected: 2
 *  {3, 1, 4, 1, 5} Expected: 0
 *  {5, 5, 5, 5, 5} Expected: 5
 */
public class LargestNumberXWhichOccursXTimes {

    /**
     * time O(n) space O(n)
     * This solution would be faster however, you would need space in memory to store the set.
     */
    public static int largestNum(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int res = 0;

        for (int num:nums) {
            // if the negated counter part is already existing, consider the number for largestNum selection.
            if(set.contains(num*-1))
                res = Math.max(res,Math.abs(num));
            else
                //keep track of the numbers read so far.
                set.add(num);
        }

        return res;
    }

    /**
     * time O(n log n) space O(1)
     * This solution would be slower but use less space in memory
     */
    public static int largestNum2(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right && nums[left] < 0 && nums[right] > 0 ) {
            if (nums[left] + nums[right] == 0) {
                return nums[right];
            }
            else if (nums[left] + nums[right] > 0) {
                right--;
            } else {
                left++;
            }
        }
        return 0;
    }
}
