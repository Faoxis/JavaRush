package com.javarush.test.level26.lesson15.big01;

import java.util.Locale;

/**
 * Created by samojlov on 19.12.16.
 */
public class CashMachine
{
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominats = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denominate = Integer.valueOf(denominats[0]);
        int value = Integer.valueOf(denominats[1]);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(denominate, value);
        System.out.println(currencyManipulator.getTotalAmount());


    }
}
