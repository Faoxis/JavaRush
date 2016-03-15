package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sergei on 18.02.2016.
 */
public abstract class Hen
{
    protected int eggs;
    int getCountOfEggsPerMonth() {
        return eggs;
    }
    String getDescription() {
        return "Я курица.";
    }
}
