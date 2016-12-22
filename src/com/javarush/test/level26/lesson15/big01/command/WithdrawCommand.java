package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.*;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.jar.Pack200;


class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true)
        {
            try {
                ConsoleHelper.writeMessage(res.getString("before"));
                int sum = Integer.valueOf(ConsoleHelper.readString());
                if (sum < 0) {
                    ConsoleHelper.writeMessage(res.getString(res.getString("specify.not.empty.amount")));
                    continue;
                }
                if (!currencyManipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }


                    Map<Integer, Integer> results = currencyManipulator.withdrawAmount(sum);
                    for (Map.Entry<Integer, Integer> result : results.entrySet()) {
                        ConsoleHelper.writeMessage(String.format("\t%s - %s", result.getKey(), result.getValue()));
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, code));
                    return;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
            }

        }
    }
}