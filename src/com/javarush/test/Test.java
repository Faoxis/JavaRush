package com.javarush.test;

import java.io.*;

/**
 * Created by samojlov on 02.12.16.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("This word has to be deleted!".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        dropAbuses(byteArrayInputStream, byteArrayOutputStream);
        System.out.println(byteArrayOutputStream.toString());
    }

    static void dropAbuses(InputStream src, OutputStream dst) throws IOException {

        byte bytes[] = new byte[src.available()];
        src.read(bytes);
        String stringWithoutWord = new String(bytes).replaceAll("word ", "");

        dst.write(stringWithoutWord.getBytes());
        dst.flush();
    }

}
