package com.jemson.test.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDateTime {

	public static void main(String[] args) {

		LocalDateTime localDateTime = LocalDateTime.now();
		String s = localDateTime.toString();
		
		System.out.println(localDateTime); // 2019-05-30T16:24:02.892
		System.out.println(s); // 2019-05-30T16:24:02.892
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		String dt = dtf.format(dateTime);
		System.out.println(dt); // 2019-05-30 16:26:50
	}

}
