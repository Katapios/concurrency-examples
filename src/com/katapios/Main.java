package com.katapios;

import java.util.concurrent.CyclicBarrier;

class Main {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("starting threads");

        new MyThread(cb, "A");
        new MyThread(cb, "B");
        new MyThread(cb, "C");
        new MyThread(cb, "D");
        new MyThread(cb, "E");
        new MyThread(cb, "F");

    }
}