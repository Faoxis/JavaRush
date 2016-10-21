package com.javarush.test.level20.tests;

import java.io.*;

/**
 * Created by sergei on 10/16/16.
 */
public class ExternalizableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SuperMegaClass superMegaClass = new SuperMegaClass("first");

        superMegaClass.setAlpha("first");
        superMegaClass.setBetta("second");
        superMegaClass.setGamma("third");

        superMegaClass.setX(1);
        superMegaClass.setY(2);
        superMegaClass.setZ(3);

        FileOutputStream fileOutput = new FileOutputStream("superMegaClass.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        outputStream.writeObject(superMegaClass);
        fileOutput.close();
        outputStream.close();

        superMegaClass = new SuperMegaClass("first");
        System.out.println("Here must be 0: " + superMegaClass.getX());
        System.out.println("Here must be 0: " + superMegaClass.getY());
        System.out.println("Here must be 0: " + superMegaClass.getZ());

        System.out.println("Here must be null: " + superMegaClass.getAlpha());
        System.out.println("Here must be null: " + superMegaClass.getBetta());
        System.out.println("Here must be null: " + superMegaClass.getGamma());

        System.out.println("\n---------------------------------------------------------\n");

        FileInputStream fileInput = new FileInputStream("superMegaClass.dat");
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        superMegaClass = (SuperMegaClass) objectInput.readObject();
        fileInput.close();
        objectInput.close();

        System.out.println("Here must be 1: " + superMegaClass.getX());
        System.out.println("Here must be 2: " + superMegaClass.getY());
        System.out.println("Here must be 3: " + superMegaClass.getZ());

        System.out.println("Here must be first: " + superMegaClass.getAlpha());
        System.out.println("Here must be second: " + superMegaClass.getBetta());
        System.out.println("Here must be third: " + superMegaClass.getGamma());
    }

    public static class SuperMegaClass implements Externalizable {
        private String alpha;
        private String betta;
        private String gamma;
        private int x;
        private int y;
        private int z;

        // Externalizable class has to have constructor without any arguments (!!!)
        public SuperMegaClass() {

        }

        public SuperMegaClass(String alpha) {
            this.alpha = alpha;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(alpha);
            out.writeObject(betta);
            out.writeObject(gamma);

            out.writeInt(x);
            out.writeInt(y);
            out.writeInt(z);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            alpha = (String) in.readObject();
            betta = (String) in.readObject();
            gamma = (String) in.readObject();

            x = in.readInt();
            y = in.readInt();
            z = in.readInt();
        }

        public String getAlpha() {
            return alpha;
        }

        public String getBetta() {
            return betta;
        }

        public String getGamma() {
            return gamma;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getZ() {
            return z;
        }

        public void setAlpha(String alpha) {
            this.alpha = alpha;
        }

        public void setBetta(String betta) {
            this.betta = betta;
        }

        public void setGamma(String gamma) {
            this.gamma = gamma;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }

}
