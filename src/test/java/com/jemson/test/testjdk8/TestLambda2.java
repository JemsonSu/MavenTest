package com.jemson.test.testjdk8;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 测试jdk8 lambda
 * @author xian
 *
 */
public class TestLambda2 {

	public static void main(String[] args) {
		
		int num = 1; // jdk7之前必须要加final 才能在匿名内部类使用
		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello lambda" + num);
			}
		};
		
		
		Runnable runnable2 = () -> System.out.println("hello lambda !!!" + num);
		
		Runnable runnable3 = () -> {
			System.out.println("hello lambda ..." + num);
		};
		
		
		Consumer<String> consumer = (t) -> System.out.println("xx:" + t);
		consumer.accept("我在北京等你！");
		
		Consumer<String> consumer2 = t -> System.out.println("xx:" + t);
		consumer2.accept("我在北京等你a！");
		
		
		Comparator<Integer> comparator = (x, y) -> {
			System.out.println("开始比较...");
			return Integer.compare(x, y);
		};
		
		Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);
		
		Comparator<Integer> comparator3 = (Integer x, Integer y) -> Integer.compare(x, y);
		
		
		
		
		
		
		
		
		
	}
	
	

}
