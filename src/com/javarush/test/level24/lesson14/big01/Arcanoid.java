package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 * Created by samojlov on 12.12.16.
 */
public class Arcanoid {
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private ArrayList<Brick> bricks;

    public Arcanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static Arcanoid game;
    public static void main(String[] args) {

    }

    public void run() {

    }

    public void move() {

    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Ball getBall()
    {
        return ball;
    }

    public Stand getStand()
    {
        return stand;
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public void setStand(Stand stand)
    {
        this.stand = stand;
    }

    public void setBricks(ArrayList<Brick> bricks)
    {
        this.bricks = bricks;
    }
}
