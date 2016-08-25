package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);

        if (args[0].equals("-e") || args[0].equals("-d")) {
            int bytes[] = new int[fileInputStream.available()];

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = fileInputStream.read();
            }

            for (int i = bytes.length - 1; i >= 0; --i) {
                outputStream.write(bytes[i]);
            }
        }

        fileInputStream.close();
        outputStream.close();
    }

}
