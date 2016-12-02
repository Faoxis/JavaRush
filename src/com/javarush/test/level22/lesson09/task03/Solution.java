package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
//        FileReader fileReader = new FileReader("/home/sergei/file1.txt");

        char buff[] = new char[1024];
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.read(buff) > 0) {
            stringBuilder.append(buff);
        }

        StringBuilder result = getLine(stringBuilder.toString().trim().split("\\s"));
        System.out.println(result.toString());

        fileReader.close();
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> tempListWords = new ArrayList<>();
        List<String> resultListWords = new ArrayList<>();

        for (String word : words) {
            tempListWords.add(word);
        }

        resultListWords.add(words[0]);
        tempListWords.remove(0);


        while (tempListWords.size() > 0) {
            String lastWord = resultListWords.get(resultListWords.size() - 1);
            char lastLetter = lastWord.toLowerCase().toCharArray()[lastWord.length() - 1];
            for (String word : tempListWords) {
                if (word.toLowerCase().toCharArray()[0] == lastLetter) {
                    resultListWords.add(word);
                    tempListWords.remove(word);
                    break;
                }
            }
        }

        for (String word : resultListWords) {
            stringBuilder.append(word);
            stringBuilder.append(" ");
        }
        stringBuilder.replace(stringBuilder.lastIndexOf(" "), stringBuilder.lastIndexOf(" ") + 1, "");

        return stringBuilder;
    }
}
