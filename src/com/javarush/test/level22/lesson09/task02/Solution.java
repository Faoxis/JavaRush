package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("name", "Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", null);
//        StringBuilder stringBuilder = getCondition(map);
//        System.out.println(stringBuilder.toString());
//    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                stringBuilder.append(entry.getKey() + " = '" + entry.getValue() + "' and ");
            }
        }
        int indexOfLastAnd = stringBuilder.lastIndexOf(" and ");
        stringBuilder.replace(indexOfLastAnd, indexOfLastAnd + " and ".length(), "");

        return stringBuilder;
    }
}
