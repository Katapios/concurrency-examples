package com.katapios;

import java.util.concurrent.Exchanger;

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;
    UseString(Exchanger<String> c) {
        ex = c;
        new Thread(this).start();
    }

    public void run() {
        for(int i = 0; i < 3; i++) {
            try {
                //exchange empty buffer for an filled one
                str = ex.exchange(new String());
                System.out.println("resived " + str);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}

