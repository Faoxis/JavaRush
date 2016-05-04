package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
//        FileInputStream file = new FileInputStream("D:\\1.txt");

        byte[] bytes = new byte[file.available()];
        file.read(bytes);
        Arrays.sort(bytes);

        int count = 0;

        for (int i = 0; i < bytes.length; i++) {
            if (i != bytes.length - 1 && bytes[i] == bytes[i + 1]) {
                count++;
            } else {
                System.out.println( (char) bytes[i] + " " + count);
            }
        }

        file.close();
    }
}
