package com.javarush.test.level21.lesson16.big01;
import java.util.ArrayList;

public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse horse1 = new Horse("x", 3, 0);
        game.getHorses().add(horse1);

        Horse horse2 = new Horse("y", 3, 0);
        game.getHorses().add(horse2);

        Horse horse3 = new Horse("z", 3, 0);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        double maxDistanse = 0;

        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistanse) {
                winner = horse;
                maxDistanse = winner.getDistance();
            }
        }

        return winner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

}
