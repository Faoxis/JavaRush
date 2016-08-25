package com.javarush.test.level18.lesson10.home08;

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

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while(!(line = reader.readLine()).equals("exit")) {
            new ReadThread(line).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run() {
            ArrayList<Integer> bytesList = new ArrayList<>();

            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int bbyte = fileInputStream.read();
                    bytesList.add(bbyte);
                }


                Collections.sort(bytesList);

                int currentByte = bytesList.get(0);
                int counter = 1;
                int max = 1;

                for (int i = 0; i < bytesList.size(); i++) {
                    if (i != bytesList.size() - 1 && bytesList.get(i).equals(bytesList.get(i + 1))) {
                        counter++;
                    } else {
                        if (counter > max) {
                            max = counter;
                            currentByte = bytesList.get(i);
                        }
                        counter = 1;
                    }
                }

                resultMap.put(fileName, currentByte);

                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
