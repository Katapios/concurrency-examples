package com.katapios;

import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    //override onAdvance() method to execute a certain number of phases
    protected boolean onAdvance(int p, int regParties) {
        //for illustration purposes only
        System.out.println("Phase " + p + " has finished.\n");
        if (p == numPhases || regParties == 0) {
            return true;
        } else {
            return false;
        }
    }
}
