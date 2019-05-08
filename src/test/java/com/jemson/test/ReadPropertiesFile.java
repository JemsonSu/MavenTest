package com.jemson.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 测试读取*.properties属性文件
 * @author xian
 *
 */
public class ReadPropertiesFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("conf/info.properties"));
		String value = properties.getProperty("spark.master");
		System.out.println("spark.masert = " + value);

	}

}
