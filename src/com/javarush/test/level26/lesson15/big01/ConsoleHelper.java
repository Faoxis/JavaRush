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

    public static String askCurrency() {
        System.out.println("Введите код валюты");
        try {
            String value = reader.readLine();
            if (value.length() != 3) {
                System.out.println("Введенная валюта состоит не из 3 символов");
            } else {
                String currencyCode = value.toUpperCase();
                System.out.println(currencyCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
        return null;
    }

    public static String[] getValidTwoDigits(String currencyCode) {

        return  null;
    }
}
