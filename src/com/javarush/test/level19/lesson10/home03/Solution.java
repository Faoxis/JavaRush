package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));

        String line;
        while ((line = file.readLine()) != null) {
            String words[] = line.split("[ ]");
            StringBuilder stringBuilder = new StringBuilder();

            if (words.length < 3) {
                continue;
            }

            for (int i = 0; i < words.length - 4; i++) {
                stringBuilder.append(words[i] + " ");
            }
            stringBuilder.append(words[words.length - 4]);

            String name = stringBuilder.toString();
            int year = Integer.valueOf(words[words.length - 1]);
            int month = Integer.valueOf(words[words.length - 2]) - 1;
            int day = Integer.valueOf(words[words.length - 3]);

            PEOPLE.add(new Person(name, new GregorianCalendar(year, month, day).getTime()));
        }

//        for (Person person : PEOPLE) {
//            System.out.println(person.getName());
//            System.out.println(person.getBirthday());
//        }
        file.close();
    }
}
