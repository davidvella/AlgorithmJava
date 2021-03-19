package com.david.vella.algorithms.medianFinder;

import lombok.NonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A Continuous Median Handler that supports:
 * 1. The continuous insertion of numbers with the addNumber method
 * 2. The instant (O(1) time) retrieval of the median of the numbers that have been inserted thus far
 *
 * The median of a set of numbers is the "middle" number when the numbers are
 * ordered from smallest to greatest. If there's an odd number of numbers in the
 * set, as in {1, 3, 7} , the median is the number in the middle (3 in this case);
 * if there's an even number of numbers in the set, as in {1, 3, 7, 8},the median
 * is the average of the two middle numbers ((3 + 7) / 2 == 5 in this case).
 * @param <T> Type of the number
 */
public class MedianFinder<T extends Number> {
    // To store lower half of data stream eg. 6,3,2,1
    Queue<T> minHeap = new PriorityQueue<>();
    // element from lower half in O(1) time
    // To store upper half of data stream eg. 8, 9, 11, 12 ,13
    Queue<T> maxHeap = new PriorityQueue<>(Collections.reverseOrder());// change to a max heap. To fetch lowest

    /**
     * Add number to the Median Finder
     *
     * @param number Number to be added
     */
    public void addNumber(@NonNull T number) {
        maxHeap.offer(number);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    /**
     * Add collection of numbers to the MedianFinder
     *
     * @param numbers A collection of numbers.
     */
    public void addNumbers(@NonNull Collection<T> numbers) {
        numbers.forEach(this::addNumber);
    }

    /**
     * Returns the median value of the collection
     *
     * @return The median value of the collection
     */
    public Double findMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        // If the number of elements is even, return the average to top elements of both heaps
        else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek().longValue() + minHeap.peek().longValue()) / 2.0;
        } else {
            return maxHeap.peek().doubleValue();
        }
    }
}