package com.javarush.test.level18.my;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while(!(line = reader.readLine()).equals("exit")) {
            new ReadThread(line);
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            start();
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run() {
            try {
                FileInputStream file = new FileInputStream(fileName);
                ArrayList<Integer> bytesList = new ArrayList<>();
                while(file.available() > 0) {
                    bytesList.add(file.read());
                }
                Collections.sort(bytesList);

                int max = 0;
                int currentByte = 0;
                for (int i = 0; i < bytesList.size(); i++) {
                    int byteFrequency = Collections.frequency(bytesList, bytesList.get(i));
                    if (byteFrequency > max) {
                        max = byteFrequency;
                        currentByte = bytesList.get(i);
                    }
                }

                resultMap.put(fileName, currentByte);

                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
