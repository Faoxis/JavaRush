package com.javarush.test.level26.lesson15.big01;

/**
 * Created by samojlov on 19.12.16.
 */
public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i > 4 || i < 1) {
            throw new IllegalArgumentException();
        }
        return Operation.values()[i];
    }
}
