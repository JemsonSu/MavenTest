package com.jemson.test.crontab;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutorsScheduledThreadPool {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		
		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
		//threadPool.schedule(new MyRun(), 3, TimeUnit.SECONDS); //寤惰繜3s鎵ц    鍙墽琛屼竴娆�
		//threadPool.schedule(new MyThread(), 5, TimeUnit.SECONDS); ////寤惰繜5s鎵ц  鍙墽琛屼竴娆�
		
		//threadPool.scheduleAtFixedRate(new MyRun(), 3, 5, TimeUnit.SECONDS);  //寤惰繜3s鎵ц    闂撮殧5s 鎵ц涓�娆�
		threadPool.scheduleWithFixedDelay(new MyThread(), 5, 10, TimeUnit.SECONDS);  //寤惰繜5s鎵ц    闂撮殧10s 鎵ц涓�娆�
		

	}

}


class MyThread extends Thread  {

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}