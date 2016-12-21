package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by samojlov on 20.12.16.
 */
class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Вы действительно хотите выйти ? <y,n>");
        String ready = ConsoleHelper.readString();
        if (ready.toUpperCase().equals("Y")) {
            ConsoleHelper.writeMessage("Good luck!");
        }
    }
}
