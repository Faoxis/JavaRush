package com.javarush.test.level28.lesson06.home01;


import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread
{
    public static AtomicInteger priorityCounter = new AtomicInteger(0);


    public MyThread()
    {
        super();
        priorityCounter.compareAndSet(11, 1);
        setPriority(priorityCounter.getAndIncrement());
    }

    public MyThread(Runnable runnable)
    {
        super(runnable);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable)
    {
        super(threadGroup, runnable);
//        if (threadGroup.getMaxPriority() > 10)
    }

    public MyThread(String s)
    {
        super(s);
    }

    public MyThread(ThreadGroup threadGroup, String s)
    {
        super(threadGroup, s);
    }

    public MyThread(Runnable runnable, String s)
    {
        super(runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s)
    {
        super(threadGroup, runnable, s);
    }

    public MyThread(ThreadGroup threadGroup, Runnable runnable, String s, long l)
    {
        super(threadGroup, runnable, s, l);
    }
}
