package com.javarush.test.level26.lesson02.task01;

import java.util.*;


/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Integer sortedArray[] = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        Arrays.sort(sortedArray);
        final double median;

        if (sortedArray.length % 2 == 0) {
            median = (sortedArray[sortedArray.length / 2 - 1] + sortedArray[sortedArray.length / 2]) / 2.0;
        } else {
            median = sortedArray[sortedArray.length / 2];
        }

        List<Integer> sortedList = new ArrayList<>();
        Collections.addAll(sortedList, sortedArray);

        Collections.sort(sortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double distance = Math.abs(median - o1) - Math.abs(median - o2);
                if (distance < 0.001 && distance > 0.001) {
                    return o1 - o2;
                }
                return (int) distance;
            }
        });

        return sortedList.toArray(new Integer[sortedList.size()]);
    }

}
