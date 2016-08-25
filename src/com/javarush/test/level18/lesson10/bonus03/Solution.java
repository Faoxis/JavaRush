package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String toFile = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(toFile)));

        if (args[0].equals("-u")) {
            long currentId = Long.valueOf(args[1]);

            String line;
            ArrayList<String> list = new ArrayList<>();
            while ((line = fileReader.readLine()) != null) {
                long lineId = getId(line);
                if (lineId == currentId) {
                    list.add(update(args));
                } else {
                    list.add(line);
                }
            }
            fileReader.close();

            FileOutputStream fileOutputStream = new FileOutputStream(toFile);
            for (int i = 0; i < list.size(); i++) {
                fileOutputStream.write((list.get(i) + "\n").getBytes());
            }
            fileOutputStream.close();

        } else if (args[0].equals("-d")) {
            long currentId = Long.valueOf(args[1]);

            String line;
            ArrayList<String> list = new ArrayList<>();
            while ((line = fileReader.readLine()) != null) {
                long lineId = getId(line);
                if (lineId != currentId) {
                    list.add(line);
                }
            }
            fileReader.close();

            FileOutputStream fileOutputStream = new FileOutputStream(toFile);
            for (int i = 0; i < list.size(); i++) {
                fileOutputStream.write((list.get(i) + "\n").getBytes());
            }
            fileOutputStream.close();
        }

        reader.close();
        fileReader.close();
    }


    public static String update(String[] parts) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clearString(parts[1], 8));
        stringBuilder.append(clearString(parts[2], 30));
        stringBuilder.append(clearString(parts[3], 8));
        stringBuilder.append(clearString(parts[4], 4));

        return stringBuilder.toString();
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
    
    public static String clearString(String str, int length) {
        char temp[] = str.toCharArray();
        char temp2[] = new char[length];
        for (int i = 0; i < temp2.length; ++i) {
            if (i < temp.length) {
                temp2[i] = temp[i];
            } else {
                temp2[i] = ' ';
            }
        }
        return new String(temp2);
    }
    
    public static long getId(String line) {
        char bytesLine[] = line.toCharArray();

        if (bytesLine.length < 8) {
            return -1;
        }

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
