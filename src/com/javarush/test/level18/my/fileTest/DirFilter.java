package com.javarush.test.level18.my.fileTest;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by sergei on 7/27/16.
 */
public class DirFilter implements FilenameFilter {
    String afn;
    public DirFilter(String afn) {
        this.afn = afn;
    }

    public boolean accept(File dir, String name) {
        String f = new File(name).getName();
        return f.indexOf(afn) != -1;
    }

}
