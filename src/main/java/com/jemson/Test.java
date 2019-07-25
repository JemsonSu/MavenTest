package com.jemson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * 
 * @author xian
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(new Date());
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("/root/test/out.log"), "utf-8"));
		String line = null;
		while ((line = myReadLine(reader)) != null) {
			
			System.out.println("读取data :" + line);
		}
		
	}
	
	/**
	 * 读取一行，并判断是当天时间内
	 * 
	 */
	public static String myReadLine(BufferedReader reader) {
		// 连读10次 读不了数据重新来读取
		String line = null;
		try {
			while (true) {
				line = reader.readLine();
				// System.out.println("line = " + line);
				if (line == null) {
					System.out.println("读取数据为空 null data");
					Thread.sleep(1000);
					continue;
				}else {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

}
