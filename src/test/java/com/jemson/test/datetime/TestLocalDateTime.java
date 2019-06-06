package com.jemson.test.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * 测试  LocalDateTime
 */
public class TestLocalDateTime {

	public static void main(String[] args) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime); // 2019-06-05T16:12:21.676
		String s1 = dateTime.format(formatter1);
		System.out.println(s1); //2019-06-05 16:12:21 676
		String s2 = dateTime.format(formatter2);
		System.out.println(s2); // 2019-06-05 16:12:21
		String s3 = dateTime.format(formatter3);
		System.out.println(s3); // 2019-06-05
		String s4 = dateTime.format(formatter4);
		System.out.println(s4); // 16:12:21
		
		
		LocalDateTime dt1 = LocalDateTime.parse("2019-06-05T23:59:59"); //必须要带T
		System.out.println(dt1);
		LocalDateTime dt2 = LocalDateTime.parse("2019-06-05T23:59:58"); //必须要带T
		LocalDateTime dt3 = LocalDateTime.parse("2019-06-06T00:00:00"); //必须要带T
		System.out.println(dt1.isAfter(dt2) + "  " + dt1.isBefore(dt2)); 
		System.out.println(dt1.isAfter(dt3) + "  " + dt1.isBefore(dt3)); 
		System.out.println(dt2.isAfter(dt3) + "  " + dt2.isBefore(dt3)); 
		
		
	}

}
