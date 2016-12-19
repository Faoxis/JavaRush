package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();
    private CurrencyManipulatorFactory() {}


    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator currencyManipulator;

        if (map.containsKey(currencyCode)) {
            currencyManipulator = map.get(currencyCode);
        } else {
            currencyManipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, currencyManipulator);
        }

        return currencyManipulator;
    }
}
