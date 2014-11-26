package com.ecfront.opentrains.codeoptimize.scala

/**
 * Created by 震宇 on 2014/8/25.
 */
object TailRecursive extends App{

  var startTime= System.nanoTime();
  recursive(1000);
  println("递归："+(System.nanoTime()-startTime));

 startTime = System.nanoTime();
  tailRecursive(1000,1);
  println("尾递归："+ (System.nanoTime() - startTime));

  def recursive(n: Int): BigInt = if (n == 0) 1 else recursive(n - 1) * n

  def tailRecursive(n: Int, rt: BigInt): BigInt = if (n == 0) rt else tailRecursive(n - 1, rt * n)
}


