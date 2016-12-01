package com.javarush.test.level22.lesson13.task01;

import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {

//    public static void main(String[] args) {
//        String[] strings = getTokens("level22.lesson13.task01", ".");
//        for (String string : strings) {
//            System.out.println(string);
//        }
//    }

    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        String[] strings = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            strings[i] = tokenizer.nextToken();
            i++;
        }

        return strings;
    }
}
