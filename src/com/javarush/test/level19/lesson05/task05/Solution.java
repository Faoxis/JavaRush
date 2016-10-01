package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        FileWriter file2 = new FileWriter(reader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        while (file1.ready()) {
            char symbols[] = new char[1024];
            file1.read(symbols);
            stringBuilder.append(new String(symbols));
        }

        String words[] = stringBuilder.toString().split("\\p{Punct}");

        for (int i = 0; i < words.length; i++) {
            file2.write(words[i]);
        }

        reader.close();
        file1.close();
        file2.close();
    }
}
