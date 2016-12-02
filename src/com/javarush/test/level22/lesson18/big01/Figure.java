package com.javarush.test.level22.lesson18.big01;

/**
 * Created by sergei on 12/2/16.
 */
public class Figure {
    private int x;
    private int y;
    private int matrix[][];

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {

    }

    public void right() {

    }

    public void down() {}
    public void up() {}
    public void downMaximum() {}
    public void rotate() {}
    public boolean isCurrentPositionAvailable() { return true;}
    public void landed() {}



    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int[][] getMatrix()
    {
        return matrix;
    }


    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setMatrix(int[][] matrix)
    {
        this.matrix = matrix;
    }
}
