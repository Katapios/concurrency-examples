package com.katapios;

class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock(){
        Thread.currentThread().setName("Main thread");
        Thread t = new Thread(this, "Rival thread");
        t.start();

        a.foo(b); //get lock for object a in current thread
        System.out.println("back to the main thread");
    }

    public void run() {
        b.bar(a); //get lock for object b in other thread
        System.out.println("back to other thread");
    }
}