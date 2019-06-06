package com.jemson.test.datetime;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * 测试  LocalDateTime
 */
public class TestLocalDateTime2 {

	public static void main(String[] args) throws Exception {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
		
		
		
		
		
		
		
		int hour = 0;
		while(true) {
			LocalDateTime dateTime = LocalDateTime.now();
			String dt1 = formatter2.format(dateTime);
			String[] dt = dt1.split(" ");
			String sDate = dt[0];
			String sTime = dt[1];
			String path = sDate;
			String file = "info.log-"+sTime;
			
			
			File dir = new File(path);
			if(!dir.exists()) {
				System.out.println("创建'"+path+"'目录"+ (dir.mkdirs()?"成功！":"失败！"));
			}
			int currentHour = dateTime.getHour(); //当前小时
			
			if(currentHour>hour) {
				new File(path+"/"+file).createNewFile();
				hour = currentHour;
			}
			
			
			
			Thread.sleep(3*1000);
		}
		
		
		
	}

}
