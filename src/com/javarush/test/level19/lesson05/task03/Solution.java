package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader file1 = new FileReader(reader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        if (file1.ready()) {
            char symbols[] = new char[1024];
            file1.read(symbols);
            stringBuilder.append(new String(symbols));
        }

        String words[] = stringBuilder.toString().split("[ ]");
        FileWriter file2 = new FileWriter(reader.readLine());
        for (int i = 0; i < words.length; i++) {
            try {
                Integer.valueOf(words[i]);
                file2.write(words[i] + " ");
            } catch (NumberFormatException e) {

            }
        }

        reader.close();
        file1.close();
        file2.close();
    }
}
