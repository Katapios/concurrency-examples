package com.katapios;

class Main {
    public static void main(String[] args) {

        NewThread test1 = new NewThread("den1");
        NewThread test2 = new NewThread("den2");
        NewThread test3 = new NewThread("den3");

        try {
            test1.t.join();
            test2.t.join();
            test3.t.join();
        } catch (InterruptedException e) {}
    }
}