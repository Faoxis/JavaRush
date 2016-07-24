package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
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
        //start here - начни тут
        switch (args[0]) {
            case "-c": {
                for (int i = 0; i < args.length-1; i += 3) {
                    Person person = getPerson(args[i+1], args[i+2], args[i+3]);
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                }
                break;
            }
            case "-u": {
                for (int i = 0; i < args.length-1; i += 4) {
                    Person person = getPerson(args[i+2], args[i+3], args[i+4]);
                    int id = Integer.valueOf(args[i+1]);
                    allPeople.remove(id);
                    allPeople.add(id, person);
                }
                break;
            }
            case "-d": {
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.valueOf(args[i]));
                    person.setSex(null);
                    person.setBirthDay(null);
                    person.setName(null);
                }
                break;
            }
            case "-i": {
                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.valueOf(args[i]));
                    String sex;
                    if (person.getSex() == Sex.MALE) {
                        sex = "м";
                    } else {
                        sex = "ж";
                    }
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.println(person.getName() + " " + sex + " "
                            + dateFormat.format(person.getBirthDay()));
                }
                break;
            }
        }
    }
}
