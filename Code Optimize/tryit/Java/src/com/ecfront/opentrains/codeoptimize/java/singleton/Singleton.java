package com.ecfront.opentrains.codeoptimize.java.singleton;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class Singleton {

    public String get(){
        return "";
    }

    private static  final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
