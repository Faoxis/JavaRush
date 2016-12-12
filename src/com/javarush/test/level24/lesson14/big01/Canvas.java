package com.javarush.test.level24.lesson14.big01;

/**
 * Created by samojlov on 12.12.16.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setPoint(double x, double y, char c) {
        int roundX = (int) Math.round(x);
        int roundY = (int) Math.round(y);

        if ((roundX < 0) || (roundY < 0) || (roundY > matrix.length) || (roundX > matrix[0].length)) {
            return;
        }
        matrix[roundX][roundY] = c;

    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x+j, y+i, c);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
