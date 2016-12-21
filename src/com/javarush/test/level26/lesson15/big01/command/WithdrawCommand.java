package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.jar.Pack200;


class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);

        while (true)
        {
            try {
                ConsoleHelper.writeMessage("Введите сумму");
                int sum = Integer.valueOf(ConsoleHelper.readString());
                if (sum < 0) {
                    ConsoleHelper.writeMessage("Нельзя ввести отрицательную сумму");
                    continue;
                }
                if (!currencyManipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage("Недостаточно средств.");
                    continue;
                }


                    Map<Integer, Integer> results = currencyManipulator.withdrawAmount(sum);
                    for (Map.Entry<Integer, Integer> result : results.entrySet()) {
                        ConsoleHelper.writeMessage(String.format("\t%s - %s", result.getKey(), result.getValue()));
                    }
                    ConsoleHelper.writeMessage("Транзакция была успешно совершена.");
                    return;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Нет необходимого количества банкнот требуемого номинала.");
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Это не число");
            }

        }
    }
}