package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        int age;
        String name;
        Human father;
        Human mother;
        Human child;
        boolean sex;


        public Human() {

        }

        public Human(int age, String name) {
            this.name = name;
            this.age = age;
        }
        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human( boolean sex, String name, int age) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, boolean sex, String name) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, boolean sex, String name, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
        }

        public Human(int age, boolean sex, String name, Human mother, Human father) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }

        public Human(int age, boolean sex, String name, Human mother, Human father, Human child) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
            this.child = child;
        }

        public Human(Human mother) {
            this.mother = mother;
        }

    }
}
