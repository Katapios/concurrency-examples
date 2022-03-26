package com.katapios;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;


class Main {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException{
        DeadThreadOne threadOne = new DeadThreadOne();
        DeadThreadTwo threadTwo = new DeadThreadTwo();
        threadOne.start();
        threadTwo.start();

        //how to catch deadlock
        Thread.sleep(1000);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        if (deadlockedThreads != null){
            ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(deadlockedThreads);
            for (ThreadInfo info : threadInfo) {
                System.out.println(info);
            }
        }
    }

    private static class DeadThreadOne extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("DeadThreadOne is holding LOCK 1...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadThreadOne is waiting for Lock 2...");
                synchronized (lock2) {
                    System.out.println("DeadThreadOne  is holding Lock 1 and Lock 2...");
                }
            }
        }
    }

    private static class DeadThreadTwo extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("DeadThreadTwo is holding LOCK 2...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("DeadThreadTwo is waiting for Lock 1...");
                synchronized (lock1) {
                    System.out.println("DeadThreadTwo  is holding Lock 1 and Lock 2...");
                }
            }
        }
    }
}
