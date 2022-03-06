package com.katapios;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();

        new LockThread(lock, "A");
        new LockThread(lock, "B");
    }
}
