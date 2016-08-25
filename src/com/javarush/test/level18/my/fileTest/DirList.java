package com.javarush.test.level18.my.fileTest;

import java.io.File;
import java.util.Arrays;

/**
 * Created by sergei on 7/27/16.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, new AlphabeticComparator());
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}


