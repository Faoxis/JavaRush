package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        char buff[] = new char[1024];

        int readCount =



        InputStreamReader streamReader = new InputStreamReader(System.in);

        char[] buf = new char[256];
        while (streamReader.read(buf) > 0) {

        }

        String line = reader.readLine();
        String words[] = line.split("[\n]");
        System.out.println(words.length);
        for (String word : words) {
            System.out.println(word);
        }

        for (int i = 0; i < words.length - 1; i++)
        {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String reverseWord = new StringBuilder(words[j]).reverse().toString();
                if (reverseWord.equals(word)) {
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = words[j];
                    result.add(pair);
                }
            }
        }

        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
