package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        int figuresCount = telNumber.replaceAll("\\D", "").length();

        // Первое условие
        if (telNumber.matches("^\\+.*") && figuresCount != 12) {
            return false;
        }

        // Второе условие
        if ((telNumber.matches("^\\d.*") || telNumber.matches("^\\(.*")) && figuresCount != 10) {
            return false;
        }

        // Третье условие
        if (telNumber.matches("(.+-.+){3,}") || telNumber.matches("--")) {
            return false;
        }

        // Четвертое условие
        if (telNumber.matches("-")) {
            if (!telNumber.matches(".*(\\(.*\\).*)?-.*")) {
                return false;
            }
        } else {
            if (!telNumber.matches(".*(\\(.*\\).*)?")) {
                return false;
            }
        }
        if (telNumber.matches(".*-.*\\(.*\\).*")) {
            return false;
        }

        if (telNumber.matches("\\({2,}") || telNumber.matches("\\){2,}")) {
            return false;
        }

        // Пятое условие
        if (telNumber.matches(".*\\(.*")) {
            if (!telNumber.matches(".*\\(\\d{3}\\).*")) {
                return false;
            }
        }

        // Шестое условие
        if (telNumber.matches("\\w")) {
            return false;
        }

        // Седьмое условие
        if (!telNumber.matches(".*\\d$")) {
            return false;
        }

        return true;
    }

}
