package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
        if (args[0].equals("-c")) {
            Person person = getPerson(args[1], args[2], args[3]);
            allPeople.add(person);
        } else if (args[0].equals("-u")) {
            Person person = getPerson(args[2], args[3], args[4]);
            int id = Integer.valueOf(args[1]);
            allPeople.remove(id);
            allPeople.add(id, person);
        } else if (args[0].equals("-d")) {
//            allPeople.remove(Integer.valueOf(args[1]));
            System.out.println(Integer.valueOf(args[1]) + 1);
            allPeople.remove(0);
            for (int i = 0; i < allPeople.size(); i++) {
                System.out.println(allPeople.get(i));
            }
        } else if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.valueOf(args[1]));
            System.out.println(person.getName() + " " + person.getSex() + " " + person.getBirthDay());
        }
    }
}
