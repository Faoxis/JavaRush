package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/
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
            stringBuilder.append(new String(buf));
        }

        String lines[] = stringBuilder.toString().split("\n");


        HashMap<String, Double> values = new HashMap<>();
        for (String line : lines) {
            String partsOfString[] = line.split("[ ]");
            if (partsOfString.length > 1) {
                String name = partsOfString[0];
//                System.out.println(name);
                Double value = Double.valueOf(partsOfString[1]);
//                System.out.println(value);

                if (values.containsKey(name)) {
                    values.put(name, values.get(name) + value);
                } else {

                }   values.put(name, value);
            }
        }

        Map<String, Object> treeMap = new TreeMap<String, Object>(values);

        Iterator iterator = treeMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry line = (Map.Entry) iterator.next();
            System.out.println(line.getKey() + " " + line.getValue());
        }

        file.close();
    }

}
