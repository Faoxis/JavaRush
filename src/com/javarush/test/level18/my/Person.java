package com.javarush.test.level18.my;

import com.javarush.test.level17.lesson10.bonus01.Sex;

import java.util.Date;

public class Person {
    private String name;
    private com.javarush.test.level17.lesson10.bonus01.Sex sex;
    private Date birthDay;

    private Person(String name, com.javarush.test.level17.lesson10.bonus01.Sex sex, Date birthDay) {
        this.name = name;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public static Person createMale(String name, Date birthDay){
        return new Person(name, com.javarush.test.level17.lesson10.bonus01.Sex.MALE, birthDay);
    }

    public static Person createFemale(String name, Date birthDay){
        return new Person(name, com.javarush.test.level17.lesson10.bonus01.Sex.FEMALE, birthDay);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.javarush.test.level17.lesson10.bonus01.Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
