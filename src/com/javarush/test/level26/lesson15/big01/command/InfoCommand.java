package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".info_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().isEmpty()) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        } else {
            for (Object object : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                CurrencyManipulator currencyManipulator = (CurrencyManipulator) object;
                if (!currencyManipulator.hasManey()) {
                    ConsoleHelper.writeMessage(res.getString("no.money"));
                } else {
                    ConsoleHelper.writeMessage(currencyManipulator.getCurrencyCode() + " - "
                            + currencyManipulator.getTotalAmount());
                }
            }
        }
    }
}