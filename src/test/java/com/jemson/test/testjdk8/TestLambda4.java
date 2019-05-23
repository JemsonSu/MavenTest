package com.jemson.test.testjdk8;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.apache.derby.tools.sysinfo;
import org.junit.Test;

/**
 * 测试jdk8 lambda
 * @author xian
 *
 */
public class TestLambda4 {

	public static void main(String[] args) {
		
		
		
	}
	
	
	@Test
	public void test1() {
		Consumer<String> con = (x) -> System.out.println(x);
		
		PrintStream ps = System.out;
		Consumer<String> con1 = ps::println;
		
		Consumer<String> con2 = System.out::println;
		con2.accept("i'am a student.");
		
		BiPredicate<String, String> bp2 = String::equals;
		boolean test = bp2.test("a", "a");
		System.out.println(test);
		
	}
	
	
	
	@Test
	public void test2() {
		
	}
	

}
