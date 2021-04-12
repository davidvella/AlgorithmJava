package com.david.vella.algorithms;

/**
 *
 */
public class KadaneAlgorithm {
    public static int KadaneAlgorithm(int[] array){

        int max_current = array[0];	//Current Maximum Subarray
        int max_global = max_current;	//Maximum Subarray

        for(int i = 1; i<array.length; i++){
            max_current = Math.max(array[i],max_current + array[i]);

            if(max_current > max_global){
                max_global = max_current;
            }
        }

        return max_global;
    }
}
