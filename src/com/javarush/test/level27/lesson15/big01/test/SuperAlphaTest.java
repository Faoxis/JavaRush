package com.javarush.test.level27.lesson15.big01.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sergei on 1/9/17.
 */
public class SuperAlphaTest {
    public static void main(String[] args) {
        List<Integer> originList = new ArrayList<>();
        originList.add(45);
        originList.add(125);
        originList.add(54);
        originList.add(1);
        originList.add(18528);

        System.out.println(originList);

        List<Integer> copyLinkList = new ArrayList<>(originList.size() + 1);
        Collections.copy(copyLinkList, originList);
        Collections.sort(copyLinkList);

        System.out.println(copyLinkList);
        System.out.println(originList);
    }
}
