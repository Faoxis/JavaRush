package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;


public class ConsoleHelper {
    private  static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".common_en");

    public static String readString()  throws InterruptOperationException
    {
        String result = null;

        try {
            result = reader.readLine();
        }
        catch (IOException e) {

        }

        if (result.toUpperCase().equals("EXIT")) {
            throw new InterruptOperationException();
        }

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
                writeMessage(res.getString("choose.currency.code"));
                String value = readString();
                if (value.length() != 3) {
                    writeMessage("Введенная валюта состоит не из 3 символов");
                } else {
                    return value.toUpperCase();
                }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
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

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation;

        while (true) {
            writeMessage(res.getString("choose.operation"));
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
                return operation;
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

}
