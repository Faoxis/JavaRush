package com.javarush.test.level16.lesson10.task01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //System.out.println(stopwatch.getSeconds());
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public int getSeconds() {
            return seconds;
        }

        public void run() {
            try {
                //add your code here - добавьте код тут
                seconds = 0;
                while(!this.isInterrupted()) {
                    Thread.sleep(1000); // В методе sleep есть проверка на isInterrupted. Если во время работы функции
                                        // окажется Interrupted = true, то произойдет InterruptedException.
                    seconds++;
                }

            } catch (InterruptedException e) {
                System.out.println(seconds); // Что и наблюдается
            }
        }
    }
}
