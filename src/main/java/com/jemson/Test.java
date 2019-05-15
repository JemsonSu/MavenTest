package com.jemson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * 项目主要测试类，测试完毕即删除测试内容
 * @author xian
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		
		URL url = new URL("http://156.234.98.218:5101/sendfile/nginx-2019-04-30_13-22-04_1556601724097.log");
		URLConnection connection = url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
		String line =null;
		while((line=reader.readLine())!=null) {
			System.out.println(line);
		}
	}

}
