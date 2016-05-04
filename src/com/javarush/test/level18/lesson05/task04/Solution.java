package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file1 = new FileInputStream(reader.readLine());
        FileOutputStream file2 = new FileOutputStream(reader.readLine());

        ArrayList<Integer> bytes = new ArrayList<>();

        while (file1.available() > 0) {
            bytes.add(file1.read());
        }

        Collections.reverse(bytes);

        for (int i = 0; i < bytes.size(); i++) {
            file2.write(bytes.get(i));
        }

        reader.close();
        file1.close();
        file2.close();


    }
}