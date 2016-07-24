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
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);

        byte[] bytes = new byte[file.available()];

        // Записываем символы в массив байт
        file.read(bytes);

        // Сортируем полученный массив
        Arrays.sort(bytes);

        // Выставляем счетчик
        int count = 1;

        // Считаем количество повторов и выводим их на экран
        for (int i = 0; i < bytes.length; i++) {
            if (i != bytes.length - 1 && bytes[i] == bytes[i + 1]) {
                count++;
            } else {
                System.out.println( (char) bytes[i] + " " + count);
                count = 1;
            }
        }

        file.close();

    }
}
