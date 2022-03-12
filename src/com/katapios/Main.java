package com.katapios;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        int pLavel;
        int threshold;

        System.out.println(
                "Parallelism=" + ForkJoinPool.commonPool().getParallelism()
        );

        System.out.println(
                "availableProcessors=" + Runtime.getRuntime().availableProcessors()
        );

        if (args.length != 2) {
            System.out.println("use FJExperiment concurrency threshold");
            return;
        }

        pLavel = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);

        long beginT, endT;
        //create task pool
        ForkJoinPool fjp = new ForkJoinPool(pLavel);

        double[] nums = new double[1000000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }

        Transform task = new Transform(nums, 0, nums.length, threshold);

        beginT = System.nanoTime();

        fjp.invoke(task);

        endT = System.nanoTime();

        System.out.println("concurrency level: " + pLavel);

        System.out.println("threshold " + threshold);

        System.out.println("time " + (endT - beginT) + " ns");

        System.out.println();
    }
}
//compile it : "javac Main.java"
//start it with params: "java Main 2 1000"