package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sergei on 18.02.2016.
 */
public class RussianHen extends Hen  implements Country
{
    RussianHen() {
        eggs = 4;
    }
    int getCountOfEggsPerMonth() {
        return eggs;
    }

    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + eggs + " яиц в месяц.");
    }

}
