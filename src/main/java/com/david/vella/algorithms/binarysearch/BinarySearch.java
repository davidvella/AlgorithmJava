package com.david.vella.algorithms.binarysearch;

public class BinarySearch {

    /**
     * O(log(n)) time | O(1) space - where n is the length of the input array
     */
    public static int binarySearch(int[] array, int target) {
        if (array.length < 1){
            return -1;
        }
        // We assume the array is already sorted. P is the beginning of the array and r is the end.
        return binarySearch(target, array, 0, array.length -1);
    }

    private static int binarySearch(int target, int[] array, int p, int r){
        int low = p;
        int high = Math.max(p,r+1);

        while(low <= high)
        {
            int mid = (low + high) >>> 1;

            /**
             * The >>> operator is the unsigned right bit-shift operator in Java.
             * It effectively divides the operand by 2 to the power of the right operand, or just 2 here.
             *
             * The difference between >> and >>> would only show up when shifting negative numbers.
             * The >> operator shifts a 1 bit into the most significant bit if it was a 1, and the >>> shifts in a 0 regardless.
             */
            if(mid > r){
                break;
            }
            else if(array[mid] < target)
                low = mid + 1;
            else if(array[mid] > target)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
