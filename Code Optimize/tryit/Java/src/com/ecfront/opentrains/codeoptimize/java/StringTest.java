package com.ecfront.opentrains.codeoptimize.java;

/**
 * Created by 震宇 on 2014/8/25.
 */
public class StringTest {

    final static int times = 10000;
   // final static int times = 1000000;

    public static void test() {
        long startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            String str = "1" + "2" + "3" + "4" + "5" + "6" + "7" + "8" + "9" + "10";
        }
        System.out.println("String： " + (System.nanoTime() - startTime));
        startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            new StringBuffer().append("1").append("2").append("3").append("4").append("5").append("6").append("7").append("8").append("9").append("10");
        }
        System.out.println("StringBuffer： " + (System.nanoTime() - startTime));
    }

    public static void test(String s) {
        long startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            s += "add";
        }
        System.out.println("String： "+ (System.nanoTime() - startTime));
    }

    public static void test(StringBuffer s) {
        long startTime = System.nanoTime();
        for (int i = 0; i < times; i++) {
            s.append("add");
        }
        System.out.println("StringBuffer： " + (System.nanoTime() - startTime));

    }

    public static void test(StringBuilder s) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            s.append("add");
        }
        System.out.println("StringBuilder： " + (System.currentTimeMillis() - startTime));
    }

    public static void testOther() {
      /*  String str1="a";
        String str2="a";
        System.out.println(str1==str2);
        str1 = "aaaaaa"+"aaaaaaa";
        str2 = "aaaaaaaaaaaaa";
        System.out.println(str1 == str2);
        */
        Integer i1=new Integer(1);
        Integer i2=new Integer(1);
        System.out.println(i1 == i2);
        i1 = new Integer(300);
        i2 = new Integer(300);
        System.out.println(i1 == i2);
    }

    public static void main(String[] args) {
        //test();
        //test("abc");
        //test(new StringBuffer("abc"));
        //test(new StringBuilder("abc"));
        testOther();
    }
}
