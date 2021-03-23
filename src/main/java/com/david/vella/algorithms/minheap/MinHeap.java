package com.david.vella.algorithms.minheap;

import java.util.List;

/**
 * THe heap is binary tree which has to have all of its levels complete except the last
 * level which is filled left to right;
 *
 * A Binary Heap is either Min Heap or Max Heap.
 * In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
 * The same property must be recursively true for all nodes in Binary Tree. Max Binary Heap is similar to MinHeap.
 *
 * BuildHeap: O(n) time | O(1) space - where n is the length of the input array
 * SiftDown: O(log(n)) time | O(1) space - where n is the length of the heap
 * SiftUp: O(log(n)) time | O(1) space - where n is the length of the heap
 * Peek: O(1) | O(1)
 * Remove: O(log(n)) time | O(1) space - where n is the length of the heap
 * Insert: O(log(n)) time | O(1) space - where n is the length of the heap
 */
public class MinHeap{
    List<Integer> heap;

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        // Write your code here.
        int firstParentIdx = (array.size() -2) / 2;
        for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--){
            siftDown(currentIdx, array.size() -1, array);
        }
        return array;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int childOneIndex = currentIdx * 2 +1;
        while (childOneIndex <= endIdx){
            int childTwoIndex = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
            int idxToSwap;
            if(childTwoIndex != -1 && heap.get(childTwoIndex) < heap.get(childOneIndex)){
                idxToSwap = childTwoIndex;
            }
            else{
                idxToSwap = childOneIndex;
            }
            if(heap.get(idxToSwap) < heap.get(currentIdx)){
                swap(currentIdx, idxToSwap, heap);
                currentIdx = idxToSwap;
                childOneIndex = currentIdx * 2 + 1;
            }
            else{
                return;
            }
        }
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        // Write your code here.
        int parentIndex = (currentIdx - 1)/2;
        while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIndex)){
            swap(currentIdx,parentIndex,heap);
            currentIdx = parentIndex;
            parentIndex = (currentIdx - 1)/2;
        }
    }

    public int peek() throws IndexOutOfBoundsException {
        return heap.get(0);
    }

    public int remove() {
        swap(0, heap.size()-1, heap);
        int valueToRemove = heap.get(heap.size() - 1);
        heap.remove(heap.size() -1);
        siftDown(0, heap.size() -1, heap);
        return valueToRemove;
    }

    public void insert(int value) {
        this.heap.add(value);
        this.siftUp(heap.size() -1, heap);
    }

    private static void swap(int i, int j, List<Integer> arr){
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i,temp);
    }
}