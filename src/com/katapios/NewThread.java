package com.katapios;

class NewThread extends Thread {

    NewThread(String name) {
        super(name);
        System.out.println("thread " + this.getName());
        start();
    }

    public void run() {
        System.out.println("thread " + this.getName() + " is started");
    }
}
