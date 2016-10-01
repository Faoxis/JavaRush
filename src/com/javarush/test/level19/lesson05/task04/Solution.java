package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader file1 = new FileReader(reader.readLine());
        FileWriter file2 = new FileWriter(reader.readLine());

        while (file1.ready()) {
            int symbol = file1.read();

            if ((char) symbol == '.') {
                file2.write('!');
            } else {
                file2.write(symbol);
            }
        }

        reader.close();
        file1.close();
        file2.close();
    }
}
