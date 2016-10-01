package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        FileReader file = new FileReader(console.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        while (file.ready()) {
            char buf[] = new char[1024];
            file.read(buf);
            stringBuilder.append(new String(buf));
        }

        String words[] = stringBuilder.toString().split("(\\p{Punct}| |\n|\t)+");

        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("world")) {
                counter++;
            }
//            System.out.println(words[i]);
        }

        System.out.println(counter);

        console.close();
        file.close();
    }
}
