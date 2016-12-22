package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by samojlov on 22.12.16.
 */
class LoginCommand implements Command
{
    ResourceBundle validCreditCards = ResourceBundle.
            getBundle(CashMachine.RESOURCE_PATH + ".verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + ".login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        String cardNumber = ConsoleHelper.readString();
        String cardPin = ConsoleHelper.readString();

        if (cardNumber.length() != 12 || cardPin.length() != 4) {
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            execute();
        }

        if (!validCreditCards.containsKey(cardNumber) || !validCreditCards.getString(cardNumber).equals(cardPin)) {
            ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            execute();
        }

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
    }
}
