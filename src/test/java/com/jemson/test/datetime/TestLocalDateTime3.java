package com.jemson.test.datetime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * 
 */
public class TestLocalDateTime3 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("f:/test/nginx.log"), "utf-8"));
		
		
		//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH"); //先用分钟代替，后面再改为小时
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd mm"); //先用分钟代替，后面再改为小时
		
		String sOldDir = "";
		String sOldFile = "";
		

		//这里循环
		LocalDateTime dateTime = LocalDateTime.now();
		String sDateTime = formatter2.format(dateTime);
		String[] dt = sDateTime.split(" ");
		String sDate = dt[0]; // yyyy-MM-dd
		String sTime = dt[1]; // HH
		
		//当前目录  到时修改为全路径
		String sDir = "./Jemson_etl/"+sDate;
		//当前文件
		String sFile = sDir + "/post.log_" + sTime;
		if(!sDir.equals(sOldDir)) {
			new File(sDir).mkdirs();
			sOldDir = sDir;
		}
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFile), "utf-8"));
		
		if(!sFile.equals(sOldFile)) {
			writer.close();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFile), "utf-8"));
			sOldFile = sFile;
			
		}
		
		
		String line = null;
		int num = 0;
		while((line = reader.readLine()) != null) {
			System.out.println(line); 
			writer.write(line);
			writer.newLine();
			num++;
			if(num%2000==0) {
				writer.flush();
			}
		}
		
		//读完一个文件
		reader.close();
		writer.close();
		
		
		
		reader = new BufferedReader(new InputStreamReader(new FileInputStream("f:/test/nginx.log"), "utf-8"));
		//writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFile), "utf-8"));
		
		
		
		
	}

}
