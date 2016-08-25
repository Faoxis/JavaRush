package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        ArrayList<String> fileList = new ArrayList<>();
        while (!(s = reader.readLine()).equals("end")) {
            fileList.add(s);
        }

        Collections.sort(fileList);
        FileOutputStream fileOutputStream = new FileOutputStream(fileList.get(0).split(".part")[0], true);
        for (int i = 0; i < fileList.size(); i++) {
            FileInputStream fileInputStream = new FileInputStream(fileList.get(i));

            byte buffer[] = new byte[1000];
            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(buffer);
                fileOutputStream.write(buffer, 0, count);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();

        reader.close();
    }
}
