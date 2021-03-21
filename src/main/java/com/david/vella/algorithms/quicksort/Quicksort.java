package com.david.vella.algorithms.quicksort;

public class Quicksort {

    public static int[] quickSort(int[] array) {
        int[] clone = array.clone();

        quickSort(clone, 0, clone.length -1);

        return clone;
    }

    private static void quickSort (int[] arr, int p, int r) {
        if(p < r){
            int q = partition(arr,p,r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q+1, r);
        }
    }

    private static int partition (int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = i + 1; j < r ; j++){
            if(arr[j] <= x){
                i = i + 1;
                exchange(i,j, arr);
            }
        }
        exchange(i+1,r, arr);
        return i + 1;
    }

    private static void exchange(int i, int j, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
