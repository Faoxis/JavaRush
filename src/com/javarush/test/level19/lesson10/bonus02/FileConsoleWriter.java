package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    @Override
    public void write(String string) throws IOException {
        super.write(string);
    }

    @Override
    public void write(char[] buf) throws IOException {
        super.write(buf);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.print(String.valueOf((char) c));
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        char[] cbuf = str.toCharArray();
        for (int i = off; i < off + len; i++) {
            System.out.print(cbuf[i]);
        }
    }

    @Override
    public void close() throws IOException {
        super.close();
    }
}
