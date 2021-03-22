package com.david.vella.algorithms.bubblesort;

public class bubblesort {
    /**
     * Best: O(n) time | O(1) space - where n is the length of the input array
     * Average: O(n^2) time | O(1) space - where n is the length of the input array
     * Worst: O(n^2) time | O(1) space - where n is the length of the input array
     */
    public static int[] bubbleSort(int[] array) {

        int l = array.length;
        for(int i = 0; i < l; i++){
            for(int j = l - 1; j >= i + 1; j--){
                if (array[j] < array[j-1]){
                    int temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
