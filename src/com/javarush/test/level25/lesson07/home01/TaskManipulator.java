package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;
    private String threadName;

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                // sleep(0) тут для того, что нить вошла в ожидание по времени и сразу была прервана,
                // тогда сразу же бросится InterruptedException и threadName никогда не будет напечатан.
                Thread.sleep(0);
                System.out.println(threadName);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {

        }

    }

    @Override
    public void start(String threadName) {
        this.threadName = threadName;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }


}
