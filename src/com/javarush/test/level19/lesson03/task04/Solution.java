package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String words[] = scanner.nextLine().split("[ ]");

            int year = Integer.valueOf(words[words.length - 1]);
            int month = Integer.valueOf(words[words.length - 2]) - 1;
            int day = Integer.valueOf(words[words.length - 3]);
            Date bithDay = new GregorianCalendar(year, month, day).getTime();

            String firstName = words[1];
            String middleName = words[2];
            String lastName = words[0];

            return new Person(firstName, middleName, lastName, bithDay);
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new PersonScannerAdapter(new Scanner(new File("/home/sergei/1.txt"))).read().toString());
    }
}
