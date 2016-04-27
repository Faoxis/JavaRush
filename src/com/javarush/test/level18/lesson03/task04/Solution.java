package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        ArrayList<Integer> bytesAll = new ArrayList<>();

        while (file.available() > 0) {
            int data = file.read();
            bytesAll.add(data);
        }

        int[] bytes = new int[256];

        for (int i = 0; i < bytesAll.size(); i++) {
            bytes[bytesAll.get(i)]++;
        }

        int min = 1;
        int maxInd = 0;

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != 0 && bytes[i] < min) {
                min = bytes[i];
                maxInd = i;
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == min) {
                System.out.print(i + " ");
            }
        }

        file.close();
        reader.close();
    }
}
