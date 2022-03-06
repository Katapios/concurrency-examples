package com.katapios;

import java.util.concurrent.Semaphore;

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Thread start " + name);
        try {
            //first obtain permission
            System.out.println("Thread " + name + " is waiting for permission");
            sem.acquire();
            System.out.println("Thread " + name + " getting permission");

            //then access to shared resource

            for (int i = 0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                //obtain switching context if possible
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        //release permission
        System.out.println("Thread " + name + " releasing permission");
        sem.release();

    }

}
