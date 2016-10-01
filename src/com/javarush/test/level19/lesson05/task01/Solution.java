package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        FileReader file1 = new FileReader(console.readLine());
        FileWriter file2 = new FileWriter(console.readLine());

        int index = 1;
        while (file1.ready()) {
            int symbol = file1.read();
            if (index % 2 == 0) {
                file2.write(symbol);
            }
            index++;
        }

        file1.close();
        file2.close();

    }
}
