package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
        } catch (IOException e) {
            logger.log(logger.getLevel().SEVERE, "Console is unavailable.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}