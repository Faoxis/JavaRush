package com.javarush.test.level18.my;

import com.javarush.test.level17.lesson10.bonus01.Person;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sergei on 28.04.2016.
 */
public class ChangingSystemIn {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static Person getPerson(String name, String sex, String bd) throws ParseException {
        Person person = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if(sex.equals("м")) person = Person.createMale(name, simpleDateFormat.parse(bd));
        else person = Person.createFemale(name, simpleDateFormat.parse(bd));
        return person;
    }

    public static void main(String[] args) throws ParseException {
        allPeople.remove(0);
        for (int i = 0; i < allPeople.size(); i++) {
            System.out.println(allPeople.get(i));
        }
    }
}
