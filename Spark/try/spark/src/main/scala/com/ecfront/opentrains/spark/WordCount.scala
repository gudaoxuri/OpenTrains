package com.ecfront.opentrains.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

object WordCount {
  def main(args: Array[String]) {
    if (args.length == 0) {
      System.err.println("Usage: WordCount <input file path>")
      System.exit(1)
    }
    val sc = new SparkContext(new SparkConf().setAppName("WordCount Application"))
    sc.textFile(args(0))
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .map(_.swap)
      .sortByKey(false)
      .map(_.swap)
      .foreach(w=>println("#"+w))
  }

}
