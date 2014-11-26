package com.ecfront.opentrains.codeoptimize.java.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class Run {

    public static final int INT = 1000;

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(new ForkJoin(0, INT));
        System.out.println("ForkJoin："+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        int sum=0;
        for (int i = 0; i < INT; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum+=i;
        }
        System.out.println("Single：" + (System.currentTimeMillis() - startTime));
    }

}
