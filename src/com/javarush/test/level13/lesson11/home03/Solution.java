package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            File myFile = new File(reader.readLine());
            FileReader fileReader = new FileReader(myFile);

            BufferedReader fReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = fReader.readLine()) != null) {
                System.out.println(line);
            }

            fReader.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}