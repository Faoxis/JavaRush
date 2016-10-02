package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();

        String string = outputStream.toString();
        String symbols[] = string.split("[ ]");

        StringBuilder stringBuilder = new StringBuilder();
        int number1 = Integer.valueOf(symbols[0]);
        String action = symbols[1];
        int number2 = Integer.valueOf(symbols[2]);

        String result = "";
        if (action.equals("+")) {
            result = String.valueOf(number1 + number2);
        } else if (action.equals("-")) {
            result = String.valueOf(number1 - number2);
        } else if (action.equals("*")) {
            result = String.valueOf(number1 * number2);
        }

        for (int i = 0; i < symbols.length - 1; i++) {
            stringBuilder.append(symbols[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.append(result);

        System.setOut(consoleOut);
        System.out.print(stringBuilder.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

