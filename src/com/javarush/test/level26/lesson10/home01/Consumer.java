package com.javarush.test.level26.lesson10.home01;


import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!blockingQueue.isEmpty()) {
                    System.out.println(blockingQueue.take());
                }

                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
    }
    }
}
