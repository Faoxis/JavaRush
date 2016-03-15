package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String url = reader.readLine();
            url = url.substring(url.indexOf("?") + 1, url.length());
            String[] params = url.split("&");

            boolean thereIsOjb = false;

            int paramInd = 0;
            double doubleObj = 0;
            String strObj = null;
            String messObj;

            for (int i = 0; i < params.length; ++i) {
                String s = params[i];
                paramInd = params[i].indexOf("=");

                if(paramInd != -1) {
                    s = params[i].substring(0, paramInd);
                    if(s.equals("obj")) {
                        thereIsOjb = true;
                        try {
                            doubleObj = Double.parseDouble(params[i].substring(paramInd + 1, params[i].length()));
                        } catch (NumberFormatException e) {
                            strObj = params[i].substring(paramInd + 1, params[i].length());
                        }
                    }
                }

                params[i] = s;
            }

            for (int i = 0; i < params.length; ++i) {
                System.out.print(params[i] + " ");
            }

            System.out.println();
            if (thereIsOjb == true)
            {
                if (strObj != null)
                {
                    alert(strObj);
                } else alert(doubleObj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
