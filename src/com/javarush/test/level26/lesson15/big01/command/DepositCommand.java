package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominats = ConsoleHelper.getValidTwoDigits(currencyCode);
        try
        {
            int denominate = Integer.valueOf(denominats[0]);
            int value = Integer.valueOf(denominats[1]);
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            currencyManipulator.addAmount(denominate, value);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), denominate*value, currencyCode));
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(String.format(res.getString("invalid.data")));
        }
    }
}