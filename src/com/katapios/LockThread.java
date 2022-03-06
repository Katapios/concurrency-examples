package com.katapios;

import java.util.concurrent.locks.ReentrantLock;

class LockThread implements Runnable {

    String name;
    ReentrantLock lock;

    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;
        new Thread(this).start();
    }

    public void run() {
        System.out.println("Thread start " + name);
        try {
            //lock counter
            System.out.println("thread " + name + " waits for counter locks");
            lock.lock();
            System.out.println("thread " + name + " blocks counter");
            Shared.count++;
            System.out.println("thread " + name + ": " + Shared.count);
            //and now context switch if possible
            System.out.println("thread " + name + " is waiting");
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println(exc);
        } finally {
            //unlock
            System.out.println("Thread " + name + " unlocks the counter");
            lock.unlock();
        }
    }
}