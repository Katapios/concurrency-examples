package com.katapios;

import java.util.concurrent.RecursiveAction;

class SqrtTransform extends RecursiveAction {

    //threshold value
    final int seqThresold = 1000;
    //processed array
    double[] data;
    //determine the part of processed data
    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    //this method performs a parallel calculation
    @Override
    protected void compute() {
        //if the number of elements is less than the threshold value, peform future processing sequentially
        if ((end - start) < seqThresold) {
            //convert each array value to square root
            for (int i = start; i < end; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            //otherwise, continue splitting the data into smaller pieces

            //find the middle
            int middle = (start + end) / 2;

            //launch new subtasks for execution using the data split into parts
            invokeAll(
                    new SqrtTransform(data, start, middle),
                    new SqrtTransform(data, middle, end)
            );
        }
    }
}
