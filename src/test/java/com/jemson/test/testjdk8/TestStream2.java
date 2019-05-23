package com.jemson.test.testjdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.Test;

public class TestStream2 {

	public static void main(String[] args) {
		Integer [] nums = new Integer[] {1,2,3,4};
		Stream<Integer> stream = Arrays.stream(nums);
		Stream<Integer> map = stream.map(e -> e*e);
		map.forEach(System.out::println);

		
		
		System.out.println("****************");
		
		
		
		long l = LongStream.rangeClosed(0, 100000000L)
			.reduce(0,Long::sum);
		
		
		System.out.println(l);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	@Test
	public void test1() {
		List<String> list = Arrays.asList("a","BB","ac","DD");
		list.forEach(System.out::println); 
		System.out.println("**************");
		list.stream().sorted().forEach(System.out::println); 
		
//		list.stream()
//		list.parallelStream()
		
	}  
	
	
	@Test
	public void test2() { 
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Optional<Integer> optional = list.stream().reduce((i,j)-> i+j);
		System.out.println(optional.get());
		
		System.out.println("-------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} 
	
	
	
	
	
	
	

}



enum Status{
	FREE, BUSY, WORK
}
