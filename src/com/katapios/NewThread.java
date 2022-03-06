package com.katapios;

class NewThread implements Runnable {
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName) {
        t = new Thread(this, threadName);
        System.out.println("thread " + t.getName());
        suspendFlag = false;
        t.start();
    }

    public void run() {
        System.out.println(t.getName() + " is ready!");
    }
}

