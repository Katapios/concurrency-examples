package com.katapios;

import java.util.concurrent.CountDownLatch;

class Main {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);

        System.out.println("start thread of execution");

        new MyThread(cdl);

        try {
            cdl.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("thread of execution ends");
    }
}