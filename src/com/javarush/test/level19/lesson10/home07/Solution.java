package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
        FileWriter file2 = new FileWriter(args[1]);

        String line;
        boolean theFirstOne = true;
        while ((line = file1.readLine()) != null) {
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                if (words[i].toCharArray().length > 6) {
                    if (theFirstOne) {
                        file2.write(words[i]);
                        theFirstOne = false;
                    } else {
                        file2.write("," + words[i]);
                    }
                }
            }

        }

        file1.close();
        file2.close();
    }
}
