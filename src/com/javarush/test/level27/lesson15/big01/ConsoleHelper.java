package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private ConsoleHelper() {}

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {

        List<Dish> dishes = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        while (true) {

            String dish = readString();
            if (dish.equals("exit")) {
                break;
            } else {
                try {
                    dishes.add(Dish.valueOf(dish));
                } catch (IllegalArgumentException e) {
                    writeMessage(dish + " is not detected");
                }
            }
        }

        return dishes;
    }

}
