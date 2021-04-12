package com.david.vella.algorithms;

/**
 * Sometimes people repeat letters to represent extra feeling, such as "hello" -> "heeellooo", "hi" -> "hiiii".  In these strings like "heeellooo", we have groups of adjacent letters that are all the same:  "h", "eee", "ll", "ooo".
 *
 * For some given string S, a query word is stretchy if it can be made to be equal to S by any number of applications of the following extension operation: choose a group consisting of characters c, and add some number of characters c to the group so that the size of the group is 3 or more.
 *
 * For example, starting with "hello", we could do an extension on the group "o" to get "hellooo", but we cannot get "helloo" since the group "oo" has size less than 3.  Also, we could do another extension like "ll" -> "lllll" to get "helllllooo".  If S = "helllllooo", then the query word "hello" would be stretchy because of these two extension operations: query = "hello" -> "hellooo" -> "helllllooo" = S.
 *
 * Given a list of query words, return the number of words that are stretchy.
 *
 *
 * Example:
 * Input:
 * S = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * Output: 1
 * Explanation:
 * We can extend "e" and "o" in the word "hello" to get "heeellooo".
 * We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
 *
 *
 * Constraints:
 *
 * 0 <= len(S) <= 100.
 * 0 <= len(words) <= 100.
 * 0 <= len(words[i]) <= 100.
 * S and all words in words consist only of lowercase letters
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; ++i) {
            if (isMatch(S, words[i])) result++;
        }
        return result;
    }

    private boolean isMatch(String word, String dictionaryWord) {
        // The way it is spelt
        int wordPointer = 0;
        // The way it is meant to be spelt
        int dictionaryPointer = 0;

        while (wordPointer < word.length() && dictionaryPointer < dictionaryWord.length()) {
            /**
             * Rule 1: Compressed(word1) must be the same as compressed word2 [what is compressed word?
             * Remove all duplicate characters in a word and keep the original order of the rest characters, you will get a compressed word]
             */
            if(dictionaryWord.charAt(dictionaryPointer) != word.charAt(wordPointer)){
                return false;
            }

            int repeated1 = getRepeatedLength(dictionaryWord, dictionaryPointer);
            int repeated2 = getRepeatedLength(word, wordPointer);

            /**
             * Rule 2: For each distinct character in word1 and word2, the consecutive repeated times must fulfill:
             * repeated1 = repeatedTimes(char c in word1)
             * repeated2 = repeatedTimes(char c in word2)
             * (repeated1 < repeated2 && repeated2 >= 3) || repeated1 == repeated2
             */
            if((repeated1 >= repeated2 || repeated2 < 3) && repeated1 != repeated2){
                return false;
            }

            dictionaryPointer += repeated1;
            wordPointer += repeated2;
        }
        return wordPointer == word.length() && dictionaryPointer == dictionaryWord.length();
    }

    private int getRepeatedLength(String word, int start){
        int end = start;
        while (end < word.length() && word.charAt(end) == word.charAt(start)){
            end ++;
        }
        return end - start;
    }
}
