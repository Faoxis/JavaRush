package com.javarush.test.level24;

/**
 * Created by samojlov on 06.12.16.
 */
public class Test {

    public static class OuterClass {
        public class InnerClass {

        }
    }

    public static class SuperAlphaClass extends OuterClass.InnerClass {
        public SuperAlphaClass(OuterClass outerClass) {
            outerClass.super();
        }
    }

}
