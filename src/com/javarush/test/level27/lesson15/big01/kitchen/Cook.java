package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public void update(Observable obs, Object obj) {
        ConsoleHelper.writeMessage("Start cooking - "
                + obj + ", cooking time "
                + ((Order) obj).getTotalCookingTime()
                + "min");
        setChanged();
        notifyObservers(obj);
    }
}
