package com.javarush.test.level20.lesson02.my_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sergei on 10/10/16.
 */
public class TestSaveLoad {

    public static void main(String[] args) throws IOException {
        File your_file_name = File.createTempFile("your_file_name.tmp", null);
        OutputStream outputStream = new FileOutputStream(your_file_name);
        InputStream inputStream = new FileInputStream(your_file_name);

        System.out.println(new Date("Tue Oct 11 17:57:22 MSK 2016").toString());
//        Human human = new Human();
//        human.setName("Sergei");
//
//        human.save(outputStream);
//        outputStream.flush();
//
//        human.load(inputStream);
//        inputStream.close();
    }


    public static class Human extends AbstractHuman implements Saveable {
        @Override
        public void save(OutputStream outputStream) {
            PrintWriter printWriter = new PrintWriter(outputStream);

            System.out.println(this.getName() != null);
            if (this.getName() != null) {
                printWriter.println("yes");
                printWriter.println(getName());
            }

            for (Asset asset : this.getAssets()) {
                printWriter.println(asset.getName());
                printWriter.println(asset.getValue());
            }
            printWriter.close();
        }

        @Override
        public void load(InputStream inputStream) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try {
                String isName = reader.readLine();
                System.out.println(isName);

                if (isName.equals("yes")) {
                    String name = reader.readLine();
                    setName(name);
                    System.out.println(name);
                } else {
                    System.out.println("There is no name");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public interface Saveable {
        void save(OutputStream outputStream);
        void load(InputStream inputStream);
    }

    public static abstract class AbstractHuman {
        private String name;
        private ArrayList<Asset> assets = new ArrayList<>();

        public String getName() {
            return name;
        }

        public ArrayList<Asset> getAssets() {
            return assets;
        }


        public void setName(String name) {
            this.name = name;
        }

        public void setAssets(ArrayList<Asset> assets) {
            this.assets = assets;
        }

        public void addAsset(Asset asset) {
            assets.add(asset);
        }
    }

    public static class Asset {
        private String name;
        private double value;

        public Asset(String name) {
            this.name = name;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public double getValue() {
            return value;
        }
    }
}
