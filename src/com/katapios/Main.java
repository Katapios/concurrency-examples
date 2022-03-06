package com.katapios;

class Main {
    public static void main(String[] args) {
        MyPhaser phsr = new MyPhaser(1, 4);
        System.out.println("threads starts\n");

        new MyThread(phsr, "A");
        new MyThread(phsr, "B");
        new MyThread(phsr, "C");

        //waiting for a certain number of phases
        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }
        System.out.println("Phase synchronizer completed");
    }
}
