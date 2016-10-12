package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            private String firstName;
//            private String lastName;
//            private Date birthDate;
//            private boolean isMale;
//            private Country country;
            User user = new User();
            user.setBirthDate(new Date());
            user.setFirstName("Petr");
//            user.setLastName("petrov");
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            javaRush.addUser(user);

            user = new User();
            user.setBirthDate(new Date());
            user.setFirstName("Petr");
//            user.setLastName("petrov");
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            javaRush.addUser(user);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void addUser(User user) {
            users.add(user);
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.println("new");
            for (User user : users) {
                if (user.getFirstName() != null)
                    printWriter.println(user.getFirstName());
                else
                    printWriter.println("no way");

                if (user.getLastName() != null)
                    printWriter.println(user.getLastName());
                else
                    printWriter.println("no way");

                if (user.getBirthDate() != null)
                    printWriter.println(user.getBirthDate().getTime());
                else
                    printWriter.println("no way");

                printWriter.println(user.isMale());

                if (user.getCountry() != null)
                    printWriter.println(user.getCountry().toString());
                else
                    printWriter.println("no way");
            }
            printWriter.println("end");

            printWriter.close();
        }


        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            if (reader.readLine().equals("new")) {
                String line;
                while (!(line = reader.readLine()).equals("end")) {
                    User user = new User();

                    if (!line.equals("no way"))
                        user.setFirstName(line);

                    line = reader.readLine();
                    if (!line.equals("no way"))
                        user.setLastName(line);

                    line = reader.readLine();
                    if (!line.equals("no way")) {
                        Date date = new Date(Long.valueOf(line));
                        user.setBirthDate(date);
                    }


                    if (reader.readLine().equals("true")) {
                        user.setMale(true);
                    } 

                    String country = reader.readLine();

                    if (country.equals("RUSSIA")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else if (country.equals("UKRAINE")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else if (country.equals("OTHER")) {
                        user.setCountry(User.Country.OTHER);
                    }

                    users.add(user);
                }
            }

            reader.close();
        }
    }

    /*
        private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

     */
}
