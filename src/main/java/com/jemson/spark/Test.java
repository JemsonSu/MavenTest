package com.jemson.spark;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.json4s.FileInput;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("spark test");
        Properties properties = new Properties();
        properties.load(new FileInputStream("conf/info.properties"));
        System.out.println(properties.getProperty("spark.master"));

	}

}
