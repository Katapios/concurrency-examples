package com.katapios;

import java.util.concurrent.Exchanger;

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> c) {
        ex = c;
        str = new String();
        new Thread(this).start();
    }

    public void run() {
        char ch= 'A';
        for (int i = 0; i < 3; i++) {
            //fill the buffer
            for (int j = 0; j < 5; j++) {
                str += (char) ch ++;
            }
            try {
                //exchange filled buffer for an empty one
                str = ex.exchange(str);
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
