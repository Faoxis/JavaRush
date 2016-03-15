package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        BufferedReader readCons = new BufferedReader(new InputStreamReader(System.in));

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(readCons.readLine()));
            String line = null;

            ArrayList<Integer> numbArray = new ArrayList<Integer>();

            while ((line = fileReader.readLine()) != null) {
                int numb = Integer.valueOf(line);

                if (numb % 2 == 0) {
                    numbArray.add(numb);
                }
            }
            fileReader.close();

            Collections.sort(numbArray);

            for (int i = 0; i < numbArray.size(); ++i) {
                System.out.println(numbArray.get(i));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
