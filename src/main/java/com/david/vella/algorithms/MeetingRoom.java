package com.david.vella.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */
public class MeetingRoom {
    /**
     * Time/Space: O(n.lg n)/O(n)
     */
    public int minMeetingRooms(int[][] meetings) {
        // [start][end]
        // Sort by start time
        Arrays.sort(meetings, Comparator.comparing(meeting -> meeting[0]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(meetings[0][1]);
        // For each next meeting: If the earliest end time of a meeting happens before the current meeting starts,
        // i.e. top of the priority queue <= current meeting's start time, pop the top value from the queue.
        for (int i = 1; i < meetings.length; i++) {
            if (minHeap.peek() <= meetings[i][0])
                minHeap.poll();
            minHeap.add(meetings[i][1]);
        }
        return minHeap.size();
    }
}
