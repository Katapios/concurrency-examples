package com.katapios;

class Caller implements Runnable {
    String message;
    CallMe target;
    Thread t;

    public Caller(CallMe targ, String incommingMessage) {
        target = targ;
        message = incommingMessage;
        t = new Thread(this);
        t.start();
        // try {
        // t.join();
        // } catch(InterruptedException e) {}
    }

    public void run() {
        synchronized (target) {
            System.out.println("------------------------------------" + t.getName() + " is ready!");
            target.call(message);
        }
    }
}
