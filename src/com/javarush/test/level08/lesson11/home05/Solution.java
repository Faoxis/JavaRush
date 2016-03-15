package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        boolean wasSpace = false;

        //напишите тут ваш код
        char[] mass = s.toCharArray();
        mass[0] = Character.toUpperCase(mass[0]);
        for (int i = 0; i < mass.length; ++i) {
            if (mass[i] == ' ') {
                wasSpace = true;
            } else if (wasSpace) {
                mass[i] = Character.toUpperCase(mass[i]);
                wasSpace = false;
            }
        }

        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i]);
        }
    }


}
