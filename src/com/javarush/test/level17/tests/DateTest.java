package com.javarush.test.level17.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sergei on 7/19/16.
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateInDatabaseFormat = sdf.format(d);
        System.out.println("dateInDatabaseFormat: " + dateInDatabaseFormat);
        Date d1 = sdf.parse(dateInDatabaseFormat);
        System.out.println("Date read from database: " + d1);
    }
}
