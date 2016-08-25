package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(toFile)));

        long currentId = 0;
        String line;
        while ((line = fileReader.readLine()) != null) {
            long lineId = getId(line);
            if (lineId > currentId) {
                currentId = lineId;
            }
        }


        FileOutputStream fileOutputStream = new FileOutputStream(toFile, true);

        if (args[0].equals("-c")) {
            fileOutputStream.write(clear(String.valueOf(currentId + 1), 8));
            fileOutputStream.write(clear(args[1], 30));
            fileOutputStream.write(clear(args[2], 8));
            fileOutputStream.write(clear(args[3], 4));
            fileOutputStream.write((byte) '\n');
        }

        reader.close();
        fileOutputStream.close();
    }

    public static byte[] clear(String str, int legnth) {
        char temp[] = str.toCharArray();
        char temp2[] = new char[legnth];
        for (int i = 0; i < temp2.length; ++i) {
            if (i < temp.length) {
                temp2[i] = temp[i];
            } else {
                temp2[i] = ' ';
            }

        }

        return new String(temp2).getBytes();
    }

    public static long getId(String line) {
        char bytesLine[] = line.toCharArray();

        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (bytesLine[i] != ' ') {
                count++;
            }
        }

        char result[] = new char[count];
        for (int i = 0; i < count; ++i) {
            result[i] = bytesLine[i];
        }

        return Long.valueOf(new String(result));
    }
}
