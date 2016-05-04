package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file1 = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()));

        String line;

        while ( (line = file1.readLine()) != null) {
            String[] linesOfDouble = line.split(" ");

            for (int i = 0; i < linesOfDouble.length; i++) {
                file2.write(Math.round(Double.valueOf(linesOfDouble[i])) + " ");
            }

        }
        reader.close();
        file1.close();
        file2.close();


    }
}
