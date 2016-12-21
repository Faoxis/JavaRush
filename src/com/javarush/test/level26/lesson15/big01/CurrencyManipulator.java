package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
import java.util.*;


public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            counter += entry.getKey() * entry.getValue();
        }

        return counter;
    }

    public boolean hasManey() {
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() - expectedAmount >= 0;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> resultMap = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(denominations);

        int tempAmount = expectedAmount;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
            {
                int important = entry.getKey();
                if (important <= tempAmount) {
                    resultMap.put(important, resultMap.containsKey(important) ? resultMap.get(important) + 1: 1);
                    tempAmount -= important;
                }
            }
        }

        int resultSum = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            resultSum += entry.getKey() * entry.getValue();
        }

        if (resultSum != expectedAmount) {
            throw new NotEnoughMoneyException();
        }

        ArrayList<Integer> zeroList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int key = entry.getKey();
            denominations.put(key, denominations.get(key) - entry.getValue());
            if (denominations.get(key) == 0) {
                zeroList.add(key);
            }
        }

        for (Integer zeroKey : zeroList) {
            denominations.remove(zeroKey);
        }

        return resultMap;
    }
}
