package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Sergei on 18.02.2016.
 */
public class MoldovanHen extends Hen  implements Country
{
    MoldovanHen() {
        eggs = 1;
    }

    int getCountOfEggsPerMonth() {
        return eggs;
    }

    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + eggs + " яиц в месяц.");
    }

}
