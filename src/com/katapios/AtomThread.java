package com.katapios;

public class AtomThread implements Runnable {

    String name;
    Thread t;

    AtomThread(String n) {
        name = n;
        t = new Thread(this, n);
        t.start();
    }

    public void run() {
        System.out.println("thread " + name + " start");

        for (int i = 1; i <= 3; i++) {
            System.out.println(
                    "thread " + name + " resieved: " + Shared.ai.getAndSet(i)
            );
        }
    }
}