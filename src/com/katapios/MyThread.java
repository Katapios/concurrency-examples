package com.katapios;

import java.util.concurrent.Phaser;

class MyThread implements Runnable {
    Phaser phsr;
    String name;

    MyThread(Phaser p, String n) {
        phsr = p;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    public void run() {
        System.out.println("thread " + name + " starts first phase");
        phsr.arriveAndAwaitAdvance(); //notify when a phase is reached

        //make a pause to break the output order
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("thread " + name + " starts phase two");
        phsr.arriveAndAwaitAdvance();

        //make a pause to break the output order
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Thread " + name + " starts phase three");
        phsr.arriveAndDeregister();
    }
}