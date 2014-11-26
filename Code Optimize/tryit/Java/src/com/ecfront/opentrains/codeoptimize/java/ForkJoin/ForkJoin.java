package com.ecfront.opentrains.codeoptimize.java.ForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class ForkJoin extends RecursiveTask<Integer> {

    private int start;
    private int end;

    public ForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = 0;
        if ((start - end) < 100) {
            for (int i = start; i < end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoin left = new ForkJoin(start, middle);
            ForkJoin right = new ForkJoin(middle + 1, end);
            left.fork();
            right.fork();
            sum = left.join() + right.join();
        }
        return sum;
    }
}
