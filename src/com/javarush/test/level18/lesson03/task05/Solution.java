package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());

        ArrayList<Integer> bytes = new ArrayList<>();

        while(file.available() > 0) {
            bytes.add(file.read());
        }

        Collections.sort(bytes);

        System.out.print(bytes.get(0) + " ");
        for (int i = 1; i < bytes.size(); i++) {
            if (bytes.get(i) != bytes.get(i -1)) {
                System.out.print(bytes.get(i) + " ");
            }
        }
    }
}
