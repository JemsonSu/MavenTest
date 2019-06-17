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
		//threadPool.schedule(new MyRun(), 3, TimeUnit.SECONDS); //延迟3s执行    只执行一次
		//threadPool.schedule(new MyThread(), 5, TimeUnit.SECONDS); ////延迟5s执行  只执行一次
		
		//threadPool.scheduleAtFixedRate(new MyRun(), 3, 5, TimeUnit.SECONDS);  //延迟3s执行    间隔5s 执行一次
		threadPool.scheduleWithFixedDelay(new MyThread(), 5, 10, TimeUnit.SECONDS);  //延迟5s执行    间隔10s 执行一次
		

	}

}


class MyRun implements Runnable  {

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}

class MyThread extends Thread  {

	@Override
	public void run() {
		System.out.println(LocalDateTime.now() + " - " + Thread.currentThread().getId() + " - " +  Thread.currentThread().getName()); 
		
	}
}