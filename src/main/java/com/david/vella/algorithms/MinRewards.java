package com.david.vella.algorithms;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 Imagine that you're a teacher who's just graded the final exam in a class. You
 have a list of student scores on the final exam in a particular order (not
 necessarily sorted), and you want to reward your students. You decide to do so
 fairly by giving them arbitrary rewards following two rules:
 1.Any given student must receive strictly more rewards than an adjacent
 student (a student immediately to the left or to the right) with a lower
 score and must receive strictly fewer rewards than an adjacent student with
 a higher score.
 2. All students must receive at least one reward.

 Write a function that takes in a list of scores and returns the minimum number
 of rewards that you must give out to students to satisfy the two rules.

 Example = [8, 4, 2, 1, 3, 6, 7, 9, 5]
 Output = 25
 *
 */
public class MinRewards {
    /**
     * O(N) time | O(n) space
     */
    public static int minRewards(int[] scores) {
        // Keep an array of rewards per student
        int [] rewards = new int[scores.length];
        // Every student must get at least one reward
        Arrays.fill(rewards,1);

        for (int i = 1; i < scores.length; ++i){
            if (scores[i] > scores[i-1]){
                rewards[i] = rewards[i-1] + 1;
            }
        }
        for (int i = scores.length - 1; i >= 0; i--){
            if (scores[i] > scores[i + 1]){
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }

        return IntStream.of(rewards).sum();
    }
}
