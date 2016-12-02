package com.javarush.test.level22.lesson18.big01;

/**
 * Created by sergei on 12/2/16.
 */
public class Tetris {
    Figure figure;
    Field field;

    public static Tetris game;
    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }

    public void run() {

    }

    public void step() {

    }

    public Figure getFigure() {
        return figure;
    }

    public Field getField() {
        return field;
    }
}
