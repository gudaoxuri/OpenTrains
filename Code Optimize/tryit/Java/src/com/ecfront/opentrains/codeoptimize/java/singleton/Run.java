package com.ecfront.opentrains.codeoptimize.java.singleton;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class Run {

    public static void main(String[] args) {
        long startTime=System.nanoTime();
        for(int i=0;i<1000000;i++){
            Singleton.getInstance().get();
        }
        System.out.println("Singleton："+(System.nanoTime() - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            new Multiple().get();
        }
        System.out.println("Multiple：" + (System.nanoTime() - startTime));
    }

}
