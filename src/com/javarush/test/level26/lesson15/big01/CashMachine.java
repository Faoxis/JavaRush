package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.util.Locale;

/**
 * Created by samojlov on 19.12.16.
 */
public class CashMachine
{
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);
    }
}
