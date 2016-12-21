package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by samojlov on 20.12.16.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
