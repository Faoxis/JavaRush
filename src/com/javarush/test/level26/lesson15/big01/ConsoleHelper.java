package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by samojlov on 19.12.16.
 */
public class ConsoleHelper {
    private  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;

        try {
            result = reader.readLine();
        }
        catch (IOException e) {

        }

        return result;
    }

    public static String askCurrencyCode() {
        while (true) {
                writeMessage("Введите код валюты:");
                String value = readString();
                if (value.length() != 3) {
                    writeMessage("Введенная валюта состоит не из 3 символов");
                } else {
                    return value.toUpperCase();
                }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        while (true) {
            writeMessage("Введите два целых числа для " + currencyCode);
            String string = readString();
            String[] stringNumbers = string.split(" ");

            if (Integer.valueOf(stringNumbers[0]) > 0
                    && Integer.valueOf(stringNumbers[1]) > 0
                    && stringNumbers.length == 2) {
                return stringNumbers;
            } else {
                writeMessage("Указано неверное количество входных данных. Необходимо указать два числа.");
            }
        }
    }
}
