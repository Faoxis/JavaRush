package com.javarush.test.level22.lesson18.big01;


public class Field {
    private int width;
    private int height;
    private int matrix[][];

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        matrix = new int[height][width];
    }

    public void print() {
        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    public void removeFullLines() {

    }

    Integer getValue(int x, int y) {
        return matrix[y][x];
    }

    void setValue(int x, int y, int value) {
        matrix[y][x] = value;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public void setMatrix(int[][] matrix)
    {
        this.matrix = matrix;
    }
}
