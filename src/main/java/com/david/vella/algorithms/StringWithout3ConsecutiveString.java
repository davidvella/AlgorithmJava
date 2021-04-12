package com.david.vella.algorithms;

public class StringWithout3ConsecutiveString {

    /**
     * Performance: O(|N|) Length of string
     * Space: O(|N|) Size of string
     */
    public static String solution(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        int i = 2;
        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i-1) && stringBuilder.charAt(i) == stringBuilder.charAt(i-2)) {
                stringBuilder.deleteCharAt(i);
            }
            else {
               ++i;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String test = solution("eedaaad");
        String test2 = solution("eeeeee");
        String test3 = solution("deeeeeed");
    }
}
