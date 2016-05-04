package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String stringFile1 = reader.readLine();
        String stringFile2 = reader.readLine();
        reader.close();

        FileInputStream file1Input = new FileInputStream(stringFile1);
        FileInputStream file2 = new FileInputStream(stringFile2);

        byte[] bytesFromFile1 = new byte[file1Input.available()];
        file1Input.read(bytesFromFile1);
        file1Input.close();

        byte[] bytesFromFile2 = new byte[file2.available()];
        file2.read(bytesFromFile2);
        file2.close();


        FileOutputStream file1Output = new FileOutputStream(stringFile1, false);
        file1Output.write(bytesFromFile2);
        file1Output.write(bytesFromFile1);
        file1Output.close();

    }
}
