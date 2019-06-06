package com.jemson.test.crontab;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 指定延迟时间执行定时任务指定延迟时间执行定时任务
 * @author xian
 *
 */
public class TestTimerTimerTask {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		Timer timer = new Timer();
		timer.schedule(new TimerTask1(), 3*1000); //延迟三秒后执行一次就没有了
		

	}

}

class TimerTask1 extends TimerTask{

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}