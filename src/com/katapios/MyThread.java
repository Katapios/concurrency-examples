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
        while (!phsr.isTerminated()) {
            System.out.println("Thread " + name + " begin phase " + phsr.getPhase());
            phsr.arriveAndAwaitAdvance();

            //for illustration purposes only
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}