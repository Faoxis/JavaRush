package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class InfoCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage("No money available.");
        } else {
            for (Object object : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                CurrencyManipulator currencyManipulator = (CurrencyManipulator) object;
                if (!currencyManipulator.hasManey()) {
                    ConsoleHelper.writeMessage("No money available.");
                } else {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - "
                            + currencyManipulator.getTotalAmount());
                }
            }
        }
    }
}