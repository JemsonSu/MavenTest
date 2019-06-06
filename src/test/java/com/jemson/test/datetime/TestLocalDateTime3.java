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

import org.apache.commons.io.FileUtils;

/*
 * 
 */
public class TestLocalDateTime3 {

	public static void main(String[] args) throws Exception {
		String sOldDir = "";
		String sOldFile = "";

		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("f:/test/a.txt"), "utf-8"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./Jemson_etl/post.log"), "utf-8"));
			BufferedWriter hourWiter = null;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ss"); // 先用分钟代替，后面再改为小时

			


			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				writer.write(line);
				writer.newLine();
				writer.flush();
				
				
				LocalDateTime dateTime = LocalDateTime.now();
				String sDateTime = formatter.format(dateTime);
				String[] dt = sDateTime.split(" ");
				String sDate = dt[0]; // yyyy-MM-dd
				String sTime = dt[1]; // HH

				// 当前目录 到时修改为全路径
				String sDir = "./Jemson_etl/" + sDate;
				// 当前文件
				String sFile = sDir + "/post.log_" + sTime;
				
				
				if (!sDir.equals(sOldDir)) {
					new File(sDir).mkdirs();
					sOldDir = sDir;
				}
				
				if (!sFile.equals(sOldFile)) {
					if(hourWiter!=null) {
						hourWiter.close();
					}
					hourWiter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFile), "utf-8"));
					sOldFile = sFile;
					
				}
				
				hourWiter.write(line);
				hourWiter.newLine();
				hourWiter.flush();
				
				
				Thread.sleep(1*1000);
			}
			System.out.println("读完Jemson_etl/post.log文件!");

			// 读完一个文件
			reader.close();
			writer.close();

		
			
			
			Thread.sleep(30*1000);

		}

	}

}
