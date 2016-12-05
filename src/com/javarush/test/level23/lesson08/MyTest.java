package com.javarush.test.level23.lesson08;

import com.javarush.test.level20.lesson02.task05.Solution;

/**
 * Created by samojlov on 05.12.16.
 */
public class MyTest {
    private String greeting;

    public MyTest(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }


    public void printNewGreeting() {
        new MyTest("New Hello") {
            public void print() {
                System.out.println(getGreeting());
            }
        }.print();
    }

    public static void main(String[] args) {
        new MyTest("Hello!").printNewGreeting();
    }
}
