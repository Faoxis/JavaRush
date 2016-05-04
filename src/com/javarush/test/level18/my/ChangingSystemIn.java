package com.javarush.test.level18.my;

import java.io.*;

/**
 * Created by Sergei on 28.04.2016.
 */
public class ChangingSystemIn {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        // Оборачиваем строку в класс ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        // Подменяем in
        System.setIn(is);

        // Вызываем обычный метод, который не подозревает о наших манипуляциях
        readAndPrintLine();
    }

    public static void readAndPrintLine() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while(true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();

    }
}
