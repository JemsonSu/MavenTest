package com.jemson.test.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TestLocalTime {

	public static void main(String[] args) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		LocalTime now = LocalTime.now();
		System.out.println(now); // 16:26:46.896
		
		String s1 = now.format(formatter1);
		System.out.println(s1); //16:28:40
		
		//判断时间先后
		boolean flag = now.isAfter(LocalTime.of(17, 10, 0));
		System.out.println(flag);

		LocalTime lt1 = LocalTime.parse("23:59:59");
		System.out.println(lt1);
		LocalTime lt2 = LocalTime.parse("23:59:58");
		System.out.println(lt2);
		LocalTime lt3 = LocalTime.parse("00:00:00");
		System.out.println(lt3);
		
		System.out.println(lt1.isAfter(lt2) + "  " + lt1.isBefore(lt2)); 
		System.out.println(lt1.isAfter(lt3) + "  " + lt1.isBefore(lt3)); 
		System.out.println(lt2.isAfter(lt3) + "  " + lt2.isBefore(lt3)); 
		
		
		System.out.println(LocalTime.now());
		
		LocalTime lt4 = LocalTime.parse("00:01:00");
		System.out.println(lt4);
		LocalTime lt5 = LocalTime.parse("00:01:59");
		System.out.println(lt5);
		
		
		LocalTime lt6 = LocalTime.parse("00:01:10");
		System.out.println(lt6.isAfter(lt4));
		System.out.println(lt6.isBefore(lt5));
		
		System.out.println(lt6.isAfter(lt4)&&lt6.isBefore(lt5));
		
		
		
		
		
	}

}
