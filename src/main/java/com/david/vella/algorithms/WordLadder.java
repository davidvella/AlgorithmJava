package com.david.vella.algorithms;

import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        // Build the adjacency list
        for(String word : wordList){
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }
        // Queue for A*
        PriorityQueue<Pair<String, Integer>> PQ = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        PQ.add(new Pair(beginWord, 0));

        // Visited is used to keep track of the cost of the nodes that we have already visited and the cost it takes to
        // reach the node.
        Map<String, Integer> visited = new HashMap<>();
        //we start with a default cost of 1
        visited.put(beginWord, 1);

        while (!PQ.isEmpty()) {
            Pair<String, Integer> node = PQ.poll();
            String word = node.first;

            for(int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {

                    //the cost to the adjacent word is 1 plus the cost to reach the word
                    int new_cost =  visited.get(word) + 1;

                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return new_cost;
                    }

                    if (!visited.containsKey(adjacentWord) || (new_cost < visited.get(adjacentWord))){
                        visited.put(adjacentWord, new_cost);
                        int heuristic_value = h(adjacentWord, endWord);
                        int priority = new_cost + heuristic_value;
                        PQ.offer(new Pair(adjacentWord, priority));
                    }
                }
            }
        }

        return 0;
    }

    // The heuristic function -
    // The distance from the current word to the end word is at least as
    // many steps to change the unequal characters in both the strings
    private static int h(String word, String word1){
        int diff = 0;

        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=word1.charAt(i))
                diff++;
        }

        return diff;
    }

    static class Pair<U,V>{
        //first is the current word
        //second is the priority for the priority queue
        U first;
        V second;

        Pair(U first, V second){
            this.first = first;
            this.second = second;
        }
    }
}
