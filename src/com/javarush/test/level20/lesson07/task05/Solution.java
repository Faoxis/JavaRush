package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        // output and input streams
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("solution.dat"));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("solution.dat"));

        Solution savedObject = new Solution(4);
        outputStream.writeObject(savedObject);

        Thread.sleep(5000);
        inputStream.readObject();

        outputStream.close();
        inputStream.close();
    }

    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        try {
            for (int i = 0; i < speed; i++) {
                System.out.println("hello");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(speed);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        speed = in.readInt();
        runner = new Thread(this);
        runner.start();
    }
}
