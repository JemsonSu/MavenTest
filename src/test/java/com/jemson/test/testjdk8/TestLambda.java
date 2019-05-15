package com.jemson.test.testjdk8;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

import akka.actor.FSM.Event;


/**
 * 测试jdk8 lambda
 * @author xian
 *
 */
public class TestLambda {

	public static void main(String[] args) {
		Runnable runnable = () -> System.out.println("hello lambda !");

		ActionListener listener = Event -> System.out.println("button click");
		
		Runnable runnable2 = () -> {
			System.out.println("hello one");
			System.out.println("hello two");
		};
		
		BinaryOperator<Long> add = (x, y) -> x + y;
		
		BinaryOperator<Integer> add2 = (Integer i, Integer j) -> i+j;
		
		BinaryOperator<Integer> add3 = (Integer i, Integer j) -> {
			return i + j;
		};
		
		BinaryOperator<Integer> add4 = (x, y) -> x + y;
		
		
	}
	
	public void test1() {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);  //最关键是这句   要两个参数
			}
		};
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>(comparator);
		
	}
	
	//test2是test1的lambda表达式写法
	public void test2() {
		//先写左边，再写右边，不然没有提示的
		Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
		TreeSet<Integer> treeSet = new TreeSet<Integer>(comparator);
	}
	
	
	
	
	
	
	
	
	

}
