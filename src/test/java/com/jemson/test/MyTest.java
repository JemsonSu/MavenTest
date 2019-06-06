package com.jemson.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class MyTest {

	public static void main(String[] args) throws IOException {
		System.out.println("this is a test!");
		FileUtils.copyFile(new File("F:\\workspace\\MavenTest\\Jemson_etl\\post.log"), new File("F:\\workspace\\MavenTest\\Jemson_etl\\2019-06-06\\post.log-23"));

	}
	
	@Test
	public void test1() {
		System.out.println(1+1);
	}

}
