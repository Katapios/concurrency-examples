package com.katapios;

import java.util.concurrent.RecursiveAction;

public class Transform extends RecursiveAction {

    //constructor-set sequential execution threshold
    int seqThreshold;
    //processed array
    double[] data;
    //determine the part of the processed data
    int start, end;

    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = t;
    }

    @Override
    protected void compute() {
        //perform future processing sequentially if the number of elements is bellow the threshold value
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int middle = (start + end) / 2;
            //launch new subtasks for execution using the data split into parts
            invokeAll(
                    new Transform(data, start, middle, seqThreshold),
                    new Transform(data, middle, end, seqThreshold)
            );
        }
    }
}