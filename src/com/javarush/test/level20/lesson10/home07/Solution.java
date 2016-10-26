package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("/home/sergei/file1.txt");

        solution.writeObject("something 1");

        // Output initialization
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("/home/sergei/jfile.dat"));
        outputStream.writeObject(solution);
        outputStream.close();

        // Drop solution
        solution = new Solution("bred");

        // Input initialization
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/home/sergei/jfile.dat"));
        solution = (Solution) inputStream.readObject();
//        inputStream.close();

        solution.writeObject("something 2");

        solution.close();
    }

    private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        fileName = (String) in.readObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
