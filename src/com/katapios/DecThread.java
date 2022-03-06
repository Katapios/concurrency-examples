package com.katapios;

import java.util.concurrent.Semaphore;

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Thread " + name + " is starting");
        try {
            //first get permission
            System.out.println("Thread " + name + " is waiting for permission");
            sem.acquire();
            System.out.println("Thread " + name + " getting permission");

            //then get access to shared resource
            for (int i = 0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);

                //permit switching the context if it possible
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        //release permission
        System.out.println("Thread " + name + " release permission");
        sem.release();
    }
}