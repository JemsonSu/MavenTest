package com.xian.scala

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Test {

  def main(args: Array[String]): Unit = {
    println("hello scala !")
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Test")
    val sc = new SparkContext(conf)

    val sqlContext = new SQLContext(sc)

    val df = sqlContext.read.load("f:/test/my.parquet")
    df.show()



    









    sc.stop()

  }

}
