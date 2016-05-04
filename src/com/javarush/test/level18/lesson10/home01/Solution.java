package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
//        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\1.txt")));
        String line;
        int count = 0;

        while ( (line = fileReader.readLine()) != null ) {
            char[] symbols = line.toCharArray();
            for (char c : symbols) {
                if ((c > 64 && c < 91) || (c > 96 && c < 123)) {
                    count++;
                }
            }
        }

        System.out.println(count);
        fileReader.close();
    }
}
