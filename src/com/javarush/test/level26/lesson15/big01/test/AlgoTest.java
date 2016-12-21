package com.javarush.test.level26.lesson15.big01.test;

import java.util.*;

/**
 * Created by samojlov on 21.12.16.
 */
public class AlgoTest
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> resultMap = new HashMap<>();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(500, 2);
        map.put(200, 3);
        map.put(100, 1);
        map.put(50, 12);

        int amount = 600;
        Map<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
            {
                int important = entry.getKey();
                if (important <= amount) {
                    resultMap.put(important, resultMap.containsKey(important) ? resultMap.get(important) + 1: 1);
                    amount -= important;
                }
            }
        }

        int resultSum = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            resultSum += entry.getKey() * entry.getValue();
        }
        System.out.println(resultSum);


    }
}
