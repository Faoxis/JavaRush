package com.javarush.test.level08.lesson08.task05;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{

    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            System.out.println("Key: " + pair.getKey() + " - Value: " + pair.getValue());
        }
    }

    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap map = new HashMap();

        map.put("LastName1", "Name1");
        map.put("LastName2", "Name2");
        map.put("LastName3", "Name3");
        map.put("LastName4", "Name4");
        map.put("LastName5", "Name5");
        map.put("LastName6", "Name6");
        map.put("LastName7", "Name7");
        map.put("LastName8", "Name8");
        map.put("LastName9", "Name9");
        map.put("LastName10", "Name9");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>();

        int count = 0;


        ArrayList<String> theSame = new ArrayList<String>();
        ArrayList<String> allStr = new ArrayList<String>();

        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();


        while (iterator1.hasNext()) {
            Map.Entry<String, String> pair1 = iterator1.next();

            allStr.add(pair1.getValue());
        }

        for (int i = 0; i < allStr.size(); ++i) {
            String s = allStr.get(i);

            for (int j = i + 1; j < allStr.size(); ++j) {
                if (s.equals(allStr.get(j)) && i != j) {
                    theSame.add(s);
                }
            }

        }

        for (int i = 0; i < theSame.size(); ++i) {
            removeItemFromMapByValue(map, theSame.get(i));
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}