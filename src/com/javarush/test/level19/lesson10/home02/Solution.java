package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader(args[0]);
        StringBuilder stringBuilder = new StringBuilder();

        while (file.ready()) {
            char buf[] = new char[1024];
            file.read(buf);
            stringBuilder.append(buf);
        }

        String lines[] = stringBuilder.toString().split("\\n");
        HashMap<String, Double> users = new HashMap<>();

        for (int i = 0; i < lines.length; i++) {
            String words[] = lines[i].split("[ ]");
            if (words.length < 2) {
                continue;
            }

            String name = words[0];
            double value = Double.valueOf(words[1]);

            if (!users.containsKey(name)) {
                users.put(name, value);
            } else {
                users.put(name, users.get(name) + value);
            }
        }

        double maxValue = 0;
        Iterator iterator = users.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry user = (Map.Entry) iterator.next();
            if ((double) user.getValue() > maxValue) {
                maxValue = (double) user.getValue();
            }
        }

        TreeMap<String, Double> sortedUsers = new TreeMap<>(users);
        iterator = sortedUsers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry user = (Map.Entry) iterator.next();
            if ((double) user.getValue() == maxValue) {
                System.out.println(user.getKey());
            }
        }

        file.close();
    }
}
