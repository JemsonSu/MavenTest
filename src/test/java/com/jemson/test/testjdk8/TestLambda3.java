package com.jemson.test.testjdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.apache.derby.tools.sysinfo;
import org.junit.Test;

/**
 * 测试jdk8 lambda
 * 内置四大核心函数式接口
 * 1.Consumer<T> : 消费型接口
		void accept(T t);
		
	2.Supplier<T> : 供给型接口
		T get();
		
	3.Function<T, R> : 函数型接口
		R apply(T t);
		
	4.Predicate<T> : 断言型接口
		boolean test(T t);
		
	都是在java.util.function.* 下
 * @author xian
 *
 */
public class TestLambda3 {

	public static void main(String[] args) {
		
		
		
	}
	
	@Test
	public void test1() {
		happy(10000, m -> System.out.println("大保健花费"+m+"元"));
	}
	
	
	public void happy(double money, Consumer<Double> con) {
		con.accept(money);
	}
	
	
	@Test
	public void test2() {
		List<Integer> list = getNumList(10, ()-> (int)(Math.random()*100));
		list.forEach(System.out::println);
	}
	
	public List<Integer> getNumList(int num, Supplier<Integer> sup){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			Integer n = sup.get();
			list.add(n);
		}
		return list;
	}
	
	
	@Test
	public void test3() {
		System.out.println(strHandler(" xi ha love ", (s) -> s.trim()));
		System.out.println(strHandler(" xi ha love ", (s) -> s.toUpperCase()));
	}
	
	public String strHandler(String str, Function<String,String> fun) {
		return fun.apply(str);
	}
	
	
	@Test
	public void test4() {
		List<String> list = Arrays.asList("at","on","one","two","money","super"); 
		List<String> strList = filterStr(list, (s) -> s.length()>3);
		strList.forEach(System.out::println); 
	}
	
	public List<String> filterStr(List<String> list, Predicate<String> pre) {
		List<String> strList = new ArrayList<>();
		for(String s : list) {
			if(pre.test(s)) {
				strList.add(s);
			}
		}
		return strList;
	}
	
	
	
	
	
	

}
