package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominats = ConsoleHelper.getValidTwoDigits(currencyCode);
        int denominate = Integer.valueOf(denominats[0]);
        int value = Integer.valueOf(denominats[1]);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(denominate, value);
    }
}