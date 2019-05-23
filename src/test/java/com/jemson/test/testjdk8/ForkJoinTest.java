package com.jemson.test.testjdk8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Long>{
	public static void main(String[] args) {
		Instant now = Instant.now();
		//Duration.between(now, endExclusive)
		Instant now2 = Instant.now();
	}
	
	private long start;
	private long end;
	
	

	@Override
	protected Long compute() {

		
		return null;
	}

}
