package com.ecfront.opentrains.codeoptimize.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class Concurrent {

    private static final AtomicInteger atomicCounter= new AtomicInteger(0);

    private static volatile int synchronizedCounter = 0;
    private static final Object LOCK = new Object();


    public static void main(StringTest[] args) {
        Runnable atomic = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                atomicCounter.incrementAndGet();
            }
        };
        Runnable sync = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (LOCK) {
                    ++synchronizedCounter;
                }
            }
        };

        final ExecutorService atomicExecutor = Executors.newCachedThreadPool();
        final ExecutorService synchronizedExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            atomicExecutor.submit(atomic);
            synchronizedExecutor.submit(sync);
        }

        while (true) {
            System.out.println("atomicCounter : " + atomicCounter.get());
            System.out.println("synchronizedCounter : " + synchronizedCounter);
        }
    }

}
