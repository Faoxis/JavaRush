package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        if (!CurrencyManipulatorFactory.hasMany()) {
            ConsoleHelper.writeMessage("No money available");
        } else {
            for (Object object : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                CurrencyManipulator currencyManipulator = (CurrencyManipulator) object;
                System.out.println(currencyManipulator.getCurrencyCode() + " - " + currencyManipulator.getTotalAmount());
            }
        }
    }
}