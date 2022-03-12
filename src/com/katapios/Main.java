package com.katapios;

public class Main {

    public static void main(String[] args) throws Exception {
        //create a tasks pool
        //ForkJoinPool fjp = new ForkJoinPool();
        double[] nums = new double[100000];

        //assign some values
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        System.out.println("part of the original sequence");

        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(nums, 0, nums.length);

        //run the main ForkJoinTask-type task for execution
        //fjp.invoke(task);
        task.invoke();

        System.out.println(
                "part of the converted sequence " +
                        "(with four decimal places of precision) :"
        );

        for (int i = 0; i < 10; i++) {
            System.out.format("%.4f ", nums[i]);
        }
        System.out.println();
    }
}
