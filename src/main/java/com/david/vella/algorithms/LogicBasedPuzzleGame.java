package com.david.vella.algorithms;

import java.util.Random;

/**
 * Mark is fan of logic based games. However he is bored of the basic ones, like Sudoku and Mastermind, since he has solved so many of them. Recently he found a new game in which one is given a string with some question marks in it. The objective is to replace all of the question marks with letters(one letter per question mark) in such a way that no letters appears next to another letter of the same kind.
 *
 * Write a function:
 *
 * string solution(string & s);
 * that given a string puzzle, returns a copy of the string with all the question marks replaced by lowercase letters(a-z) in such a way that the same letters do not occur next to each other. The result can be any of the possible answers as long as it fulfils the above requirements.
 *
 * Examples:
 *
 * Given puzzle = 'xy?xz?', your function might return 'xycxza'.
 * Some other possible results are 'xyzxzd', 'xyfxzf'.
 *
 * Given puzzle = 'ab?e?mr??'. Your function might return 'abveamrab'
 *
 * Given puzzle = '??????'. Your function might return 'league'
 * Write an efficient algorithm for the following assumptions:
 *
 * String puzzle contains only of lowercase letters(a-z) or '?'
 * It is always possible to turn string 'puzzle' into a string without two identical consecutive letters
 */
public class LogicBasedPuzzleGame {

    public static String solution(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        int len = stringBuilder.length();
        Random random = new Random();

        for (int index = 0; index < len; ++index){
            char character = stringBuilder.charAt(index);
            // Replace character here
            if(character == '?'){
                // Max value is exclusive.
                // ... So this returns 1, 2, through 25.
                // Worst case needs to iterate twice
                while (true){
                    // Generate random char between a and z
                    char rc = (char)(random.nextInt(26) + 'a');

                    if ((index == 0 || rc != stringBuilder.charAt(index -1))
                            && (index == len - 1 || rc != stringBuilder.charAt(index + 1))) {
                        stringBuilder.setCharAt(index , rc);
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String test = "??????";
        String result = solution(test);
    }


}
