package com.katapios;

import java.util.concurrent.Phaser;

class Main {
    public static void main(String[] args) {
        Phaser phsr = new Phaser(1);
        int curPhase;

        System.out.println("Threads start");

        new MyThread(phsr, "A");
        new MyThread(phsr, "B");
        new MyThread(phsr, "C");

        //waiting for all threads to complete the first phase

        curPhase = phsr.getPhase() + 1;
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        curPhase = phsr.getPhase() + 1;
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        curPhase = phsr.getPhase() + 1;
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");

        phsr.arriveAndDeregister();

        if (phsr.isTerminated()) {
            System.out.println("Phase synchroniser completed");
        }

    }
}
