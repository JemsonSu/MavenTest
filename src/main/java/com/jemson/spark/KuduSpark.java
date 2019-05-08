package com.jemson.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.hive.HiveContext;

/**
   * 用spark去处理创建然后进入kudu库
 * @author xian
 *
 */
public class KuduSpark {

	public static void main(String[] args) {
		System.out.println("开始KuduSpark测试。。。");
		
		SparkConf conf = new SparkConf();
		conf.setMaster("local[2]");
		conf.setAppName("KuduSpark");
		JavaSparkContext jsc = new JavaSparkContext(conf);

		HiveContext hiveContext = new HiveContext(jsc);
		DataFrame dataFrame = hiveContext.sql("SELECT count(p__city) c FROM db1.event");
		dataFrame.show();
		
		
		
		jsc.stop();
		jsc.close();
		
		System.out.println("测试完毕！！！");

	}

}
