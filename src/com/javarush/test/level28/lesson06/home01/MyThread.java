package com.javarush.test.level28.lesson06.home01;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.jar.Pack200;

public class MyThread extends Thread
{
    public static AtomicInteger priorityCounter = new AtomicInteger(1);


    public MyThread() {
        super();
        priorityCounter.compareAndSet(11, 1);
        setPriority(priorityCounter.getAndIncrement());
    }

    public MyThread(Runnable runnable)
    {
        super(runnable);
        init();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable)
    {
        super(threadGroup, runnable);
        init(threadGroup);
    }

    public MyThread(String s)
    {
        super(s);
        init();
    }

    public MyThread(ThreadGroup threadGroup, String s)
    {
        super(threadGroup, s);
        init(threadGroup);
    }

    public MyThread(Runnable runnable, String s)
    {
        super(runnable, s);
        init();
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s)
    {
        super(threadGroup, runnable, s);
        init(threadGroup);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l)
    {
        super(threadGroup, runnable, s, l);
        init(threadGroup);
    }

    private void init() {
        priorityCounter.compareAndSet(11, 1);
        setPriority(priorityCounter.getAndIncrement());
    }

    private void init(ThreadGroup threadGroup) {
        priorityCounter.compareAndSet(11, 1);
        synchronized (MyThread.class) {
            if (threadGroup.getMaxPriority() < priorityCounter.get()) {
                setPriority(threadGroup.getMaxPriority());
                priorityCounter.incrementAndGet();
            } else {
                setPriority(priorityCounter.getAndIncrement());
            }
        }
    }
}
