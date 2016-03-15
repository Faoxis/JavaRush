package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sergei on 18.02.2016.
 */
public class BelarusianHen extends Hen implements Country
{
    BelarusianHen() {
        eggs = 2;
    }

    int getCountOfEggsPerMonth() {
        return eggs;
    }

    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + eggs + " яиц в месяц.");
    }

}
