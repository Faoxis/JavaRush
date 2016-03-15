package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sergei on 18.02.2016.
 */
public class UkrainianHen extends Hen  implements Country
{
    UkrainianHen() {
        eggs = 3;
    }
    int getCountOfEggsPerMonth() {
        return eggs;
    }

    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + eggs + " яиц в месяц.");
    }

}
