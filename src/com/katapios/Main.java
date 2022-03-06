package com.katapios;

import java.util.concurrent.Semaphore;

class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "B");

    }
}