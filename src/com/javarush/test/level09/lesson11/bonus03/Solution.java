package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();


        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (int i = 0; i < array.length; ++i) {
            System.out.println(array[i]);
        }

    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> numbs = new ArrayList<Integer>();
        ArrayList<Integer> numbsIndex = new ArrayList<Integer>();

        ArrayList<String> strings = new ArrayList<String>();
        ArrayList<Integer> stringsIndex = new ArrayList<Integer>();

        for (int i = 0; i < array.length; ++i) {
            if (isNumber(array[i])) {
                numbs.add(Integer.valueOf(array[i]));
                numbsIndex.add(i);
            }
            else if (!isNumber(array[i])) {
                strings.add(array[i]);
                stringsIndex.add(i);
            }
        }

        Collections.sort(numbs);
        Collections.sort(strings);

        for (int i = 0; i < numbsIndex.size(); ++i) {
            array[numbsIndex.get(i)] = String.valueOf(numbs.get(numbsIndex.size() - i - 1));
        }

        for (int i = 0; i < stringsIndex.size(); ++i) {
            array[stringsIndex.get(i)] = strings.get(i);
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {

        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
