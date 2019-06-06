package com.jemson.test.datetime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {

	public static void main(String[] args) {
		DateTimeFormatter  formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		LocalDate now = LocalDate.now();
		System.out.println(now); //2019-06-05
		
		String s1 = now.format(formatter1);
		System.out.println(s1); // 2019/06/05
		
		int year = now.getYear();
		Month month = now.getMonth();
		int i_month = month.getValue();
		int day = now.getDayOfMonth();
		System.out.println(year+"年"+i_month+"月"+day+"日"); 
		
		LocalDate ld = now.plusDays(2); //加两天
		System.out.println(ld);
		LocalDate ld2 = now.minusDays(3); //减两天
		System.out.println(ld2);
		
		
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock); // SystemClock[Asia/Shanghai]
		
		long millis = clock.millis();
		System.out.println(millis);
		
		
		

	}

}
