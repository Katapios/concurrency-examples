package com.katapios;

class Main {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("thread one");
        NewThread ob2 = new NewThread("thread two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("pause thread one");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("play thread one");
            ob2.mySuspend();
            System.out.println("pause thread two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("play thread two");
        } catch (InterruptedException e) {
            System.out.println("main thread is interrupted");
        }

        try {
            System.out.println("waiting for threads finished");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("main thread is interrupted");
        }
        System.out.println("main thread is finished");
    }
}
