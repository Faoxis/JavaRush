package com.javarush.test.level22.lesson05.myTests;

/**
 * Created by sergei on 11/3/16.
 */
public class IndexOfTabTest {
    public static void main(String[] args) {
        System.out.println(getPartOfString("J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"));
    }

    public static String getPartOfString(String string) {

        // 1. Метод getPartOfString должен возвращать подстроку между первой и последней табуляцией.
        // Можно решить через регулярку, но лучше средствами, которые были даны в лекции
        int firstTab = string.indexOf("\t");
        int lastTab = firstTab;

        while (true) {
            int tempTab = string.indexOf("\t", lastTab + 1);
            if (tempTab != -1) {
                lastTab = tempTab;
            } else {
                break;
            }
        }

        return string.substring(firstTab + 1, lastTab);
    }
}
