package com.jemson.spark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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

	public static void main(String[] args) throws Exception {
		System.out.println("开始KuduSpark测试。。。");
		//获取配置文件信息
		Properties properties = new Properties();
		//String userDir = System.getProperty("user.dir"); //获取当前项目根目录
		//System.out.println("|" + userDir + "|"); // |D:\ideaWorkspace\Java201903|
		//properties.load(new FileInputStream("info.properties"));
		//String master = properties.getProperty("spark.master").trim();
		//System.out.println("spark.masert = " + master);
		//String sql = properties.getProperty("spark.sql").trim();
		String sql = "SELECT count(p__city) c FROM db1.event";
		//System.out.println("spark.sql = " + sql);
		
		SparkConf conf = new SparkConf();
		//conf.setMaster(master); //线上测试就在脚本设置即可
		//conf.setAppName("KuduSpark");
		JavaSparkContext jsc = new JavaSparkContext(conf);

		HiveContext hiveContext = new HiveContext(jsc);
		DataFrame dataFrame = hiveContext.sql(sql);
		dataFrame.show();
		
		
		
		jsc.stop();
		jsc.close();
		
		System.out.println("测试完毕！！！");

		
	}
	
	
	

}
