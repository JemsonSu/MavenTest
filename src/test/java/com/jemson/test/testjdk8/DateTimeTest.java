package com.jemson.test.testjdk8;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DateTimeTest {

	public static void main(String[] args) throws Exception {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
		
		LocalDateTime dateTime = LocalDateTime.of(2015, 3, 20, 12, 34, 56);
		System.out.println(dateTime);
		System.out.println(dateTime.plusDays(2));
		System.out.println(dateTime.minusDays(3));
		
		System.out.println(localDateTime.getDayOfMonth());
		
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		
		
		
		//时间戳  Unix 元年 1970
		Instant now = Instant.now(); //获取的是UTC时区   跟中国差8个小时
		System.out.println(now); 
		OffsetDateTime odt = now.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		System.out.println(odt.getHour());
		
		
		Instant in2 = Instant.ofEpochMilli(23); //unix元年加23分钟
		System.out.println(in2); // 1970-01-01T00:00:00.023Z
		
		
		Instant in3 = Instant.now();
		//Thread.sleep(3*1000);
		Instant in4 = Instant.now();
		Duration duration = Duration.between(in3, in4);
		System.out.println(duration.getSeconds());
		
		
		LocalTime time1 = LocalTime.now();
		//Thread.sleep(5*1000);
		LocalTime time2 = LocalTime.now();
		Duration duration2 = Duration.between(time1,time2);
		System.out.println(duration2.getSeconds());
		
		
		
		LocalDate date1 = LocalDate.of(2015, 1, 1);
		LocalDate date2 = LocalDate.now();
		
		Period period = Period.between(date1, date2); 
		System.out.println(period);
		System.out.println(period.getYears());
		
		
		LocalDateTime dateTime2 = LocalDateTime.now();
		System.out.println(dateTime2);
		
		
		
		DateTimeFormatter dtf23 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter dtf24 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime3 = LocalDateTime.now();
		System.out.println(dateTime2);
		System.out.println(dtf23.format(dateTime3));
		System.out.println(dtf24.format(dateTime3));
		
		
		
		
		
		
	}

}
