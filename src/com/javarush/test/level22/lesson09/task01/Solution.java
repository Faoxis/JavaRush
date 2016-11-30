package com.javarush.test.level22.lesson09.task01;

import java.io.*;
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
        FileReader fileName = new FileReader(reader.readLine());

        char buff[] = new char[1024];
        StringBuilder stringBuilder = new StringBuilder();
        while(fileName.read(buff) > 0) {
            stringBuilder.append(buff);
        }

        // заменяем все символы перехода на новую строку на пробельные символы
        int indexOfEnter = stringBuilder.indexOf("\n");
        while (indexOfEnter > 0) {
            stringBuilder.replace(indexOfEnter, indexOfEnter + 1, " ");
            indexOfEnter = stringBuilder.indexOf("\n");
        }

        int indexOfFirstSpace = 0;
        int indexOfSecondSpace = stringBuilder.indexOf(" ");
        List<String> words = new ArrayList<>();

        while (indexOfSecondSpace > 0) {
            String word = stringBuilder.substring(indexOfFirstSpace, indexOfSecondSpace );
            words.add(word);
            indexOfFirstSpace = indexOfSecondSpace + 1;
            indexOfSecondSpace = stringBuilder.indexOf(" ", indexOfSecondSpace + 1);
        }

        for (int i = 0; i < words.size() - 1; ++i) {
            String firstWord = words.get(i);
            for (int j = i + 1; j < words.size(); ++j) {
                String secondWord = words.get(j);

                if (firstWord.equals(new StringBuilder(secondWord).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = firstWord;
                    pair.second = secondWord;
                    result.add(pair);
                    words.remove(j);
                    words.remove(i);
                    break;
                }
            }
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
