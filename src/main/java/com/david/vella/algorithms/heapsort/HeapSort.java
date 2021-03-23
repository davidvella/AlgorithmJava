package com.david.vella.algorithms.heapsort;

public class HeapSort {

    /**
     * Best: O(nlog(n)) time | O(1) space - where n is the length of the input array
     * Average: O(nlog(n)) time | O(1) space - where n is the length of the input array
     * Worst: O(nlog(n)) time | O(1) space - where n is the length of the input array
     *
     * Code: O(n) build heap, O(nlogn) convert heap to sorted array
     *
     * A Binary Heap is either Min Heap or Max Heap.
     * In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
     * The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.
     */
    public static int[] heapSort(int[] array) {
        //build the heap
        for(int i=array.length-1;i>=0;i--)
            //merge the 2 sub-heaps below i, by bubbling nums[i] down to the correct location
            sink(array,i,array.length);
        //turn it into a sorted list
        for(int i=array.length-1;i>0;i--){
            //remove the root, and put the last leaf at the root of the heap
            swap(0,i,array);
            //bubble the new root down to the correct location
            sink(array,0,i);
        }
        return array;
    }

    static void sink(int[] nums, int start, int end){
        int val = nums[start];
        int i = start, next = 2*i+1;
        while(next<end){
            if(next+1<end && nums[next+1]>nums[next])
                next++;
            if(nums[next]<=val)
                break;
            nums[i]=nums[next];
            i=next;
            next = 2*i+1; //2*i+1, 2*i+2 are the children of i
        }
        nums[i]=val;
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
