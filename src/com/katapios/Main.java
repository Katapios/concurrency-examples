package com.katapios;

public class Main {

    public static void main(String[] args) throws Exception {
        AtomThread t1 = new AtomThread("A");
        t1.t.join();
        AtomThread t2 = new AtomThread("B");
        t2.t.join();
        AtomThread t3 = new AtomThread("C");
        t3.t.join();
    }
}