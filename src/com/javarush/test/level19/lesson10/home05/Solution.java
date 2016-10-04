package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        FileWriter fileOut = new FileWriter(args[1]);

        String line;
        while ((line = fileIn.readLine()) != null) {
            String[] words = line.split("[ ]");

            boolean readyLine = false;
            ArrayList<String> writingWords = new ArrayList<>();
            for (String word : words) {
                String letters[] = word.split("");

                boolean readyWord = false;
                for (String letter : letters) {

                    try {
                        Integer.valueOf(letter);
                        readyWord = true;
                        readyLine = true;
                    } catch (NumberFormatException e) {

                    }
                }
                if (readyWord) {
                    writingWords.add(word);
                }
            }


            if (writingWords.size() > 1) {
                for (int i = 0; i < writingWords.size() - 1; i++) {
                    fileOut.write(writingWords.get(i) + " ");
                }
                fileOut.write(writingWords.get(writingWords.size() - 2));
            } else if (writingWords.size() == 1) {
                fileOut.write(writingWords.get(0));
            }

            if (readyLine) {
                fileOut.write("\n");
            }

        }

        fileIn.close();
        fileOut.close();
    }
}
