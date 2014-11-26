package com.ecfront.opentrains.codeoptimize.scala

/**
 * Created by 震宇 on 2014/8/25.
 */
object Parallel extends App{

  test(10000);

  test(1000000);

  def test(max:Int)={
    val list = (1 to max).toList
    var startTime = System.nanoTime();
    list.map(_ + 1).reduce(_ + _)
    println("顺序：" + (System.nanoTime() - startTime));

    startTime = System.nanoTime();
    list.par.map(_ + 1).reduce(_ + _)
    println("并行：" + (System.nanoTime() - startTime));
  }
}


