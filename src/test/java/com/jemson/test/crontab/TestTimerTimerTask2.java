package com.jemson.test.crontab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.time.DateUtils;
/**
 * 在指定时间执行定时任务
 * @author xian
 *
 */
public class TestTimerTimerTask2 {

	public static void main(String[] args) throws Exception {
		System.out.println(LocalDateTime.now());
		Timer timer = new Timer();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = formatter.parse("2019-06-06 11:14:00");
		timer.schedule(new TimerTask2(), date);
		

	}

}

class TimerTask2 extends TimerTask{

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}