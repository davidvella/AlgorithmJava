package com.david.vella.algorithms;

/**
 * Determine Final sign after multiplication of elements in array
 */
public class FindSignMultipleNumberInArray {

    /**
     * Determine Final sign after multiplication of elements in array
     * Big O:
     * Time (N)
     * Space (1)
     */
    public static int solution(long[] array){
        // We don't need to multiply the values but rather keep track of the signum
        // -1 , 0, 1
        if(array.length == 0) return 0;

        int signum = 1;
        for (long num : array){
            signum *= Long.signum(num);
        }
        return signum;
    }

}
