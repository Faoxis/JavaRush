package com.javarush.test.level19.lesson10.bonus02;

import java.io.IOException;

/**
 * Created by sergei on 10/4/16.
 */
public class TestFileConsoleWriter {
    public static void main(String[] args) throws IOException {
        FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("/home/sergei/file1.txt");
        char[] mass = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char c = '2';
        fileConsoleWriter.write("Hello there!");
        fileConsoleWriter.write(mass);
        fileConsoleWriter.write('9');
        fileConsoleWriter.write(mass, 2, 5);
        fileConsoleWriter.write("Hello there", 2, 5);

        fileConsoleWriter.close();
    }
}
