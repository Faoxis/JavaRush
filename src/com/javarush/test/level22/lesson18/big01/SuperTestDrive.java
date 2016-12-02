package com.javarush.test.level22.lesson18.big01;

/**
 * Created by samojlov on 02.12.16.
 */
public class SuperTestDrive {
    public static void main(String[] args) {
        Field field = new Field(6, 2);
        field.setValue(0, 0, 1);
        field.setValue(1,0,1);
        field.setValue(0, 1, 1);
        field.print();
    }
}
