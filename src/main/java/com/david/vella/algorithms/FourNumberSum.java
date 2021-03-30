package com.david.vella.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {

    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
     * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     *
     * Notice that the solution set must not contain duplicate quadruplets.
     * Average: O(n^2) time | O(n^2) space - where n is the length of the input array
     * Worst: O(n^3) time | O(n^2) space - where n is the length of the input arra
     */
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> res = new ArrayList<>();
        if(array == null || array.length < 4){  //corner case
            return res;
        }

        int[] nums = array.clone();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if(curr == targetSum){
                        res.add(new Integer[]{nums[i], nums[j], nums[left], nums[right]});
                        left++; right--;
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if(curr > targetSum){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
