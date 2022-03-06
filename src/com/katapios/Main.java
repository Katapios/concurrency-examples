package com.katapios;

class Main {
    public static void main(String[] args) {
        CallMe target = new CallMe();

        try {

            Caller ob1 = new Caller(target, "wellcome");
            ob1.t.setName("Thread №1");
            ob1.t.join();

            Caller ob2 = new Caller(target, "to the synchronized");
            ob2.t.setName("Thread №2");
            ob2.t.join();

            Caller ob3 = new Caller(target, "world!");
            ob3.t.setName("Thread №3");
            ob3.t.join();

        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }

    }
}