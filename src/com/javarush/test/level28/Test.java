package com.javarush.test.level28;

/**
 * Created by samojlov on 27.12.16.
 */
public class Test
{
    public static class MyThread extends Thread {

        public MyThread()
        {
        }

        public MyThread(Runnable runnable)
        {
            super(runnable);
        }

        public MyThread(ThreadGroup threadGroup, Runnable runnable)
        {
            super(threadGroup, runnable);
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

        @Override
        public void run() {
            System.out.println("Hello from group " + getThreadGroup().getParent().getMaxPriority());
        }
    }


    public static void main(String[] args)
    {
        ThreadGroup threadGroup = new ThreadGroup("Super thread group");
        new MyThread(threadGroup, "Thread with the group").start();
        new MyThread("Thread without any group").start();
    }
}
