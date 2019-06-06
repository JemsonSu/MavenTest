package com.jemson.test.crontab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.lang3.time.DateUtils;
/**
 *  在延迟指定时间后以指定的间隔时间循环执行定时任务
 * @author xian
 *
 */
public class TestTimerTimerTask3 {

	public static void main(String[] args) throws Exception {
		System.out.println(LocalDateTime.now());
		Timer timer = new Timer();


		// delay-延迟多少ms执行任务    period-每次执行间隔ms
		timer.schedule(new TimerTask3(), 3*1000, 5*1000);
		

	}

}

class TimerTask3 extends TimerTask{

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}