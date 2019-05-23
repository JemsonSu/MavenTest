package com.jemson.test.testjdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * stream 数据渠道
 * @author xian
 *
 */
public class TestStream {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("aAa","bBb","cc","DD");
		Stream<String> stream = list.stream();
		stream.filter((e)->e.length()>2)
		.skip(1)
		.limit(3)
		.forEach(System.out::println); 
		
	}
	
	@Test
	public void test3() {
		
	}
	
	@Test
	public void test2() {
		List<String> list = Arrays.asList("aAa","bBb","cc","DD");
		Stream<String> stream = list.stream();
		
		/*Optional<String> optional = stream.findFirst();
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}*/
		
		Stream<String> filterStream = stream.filter((e) -> e.length()>2);
		filterStream.forEach(System.out::println);
		
		
		
	}
	
	@Test
	public void test1() {
		List<String> list = Arrays.asList("a","b","cc","DD");
		Stream<String> stream = list.stream();

		
		Integer [] ii = new Integer [] {1,2,4,5,8,9};
		Stream<Integer> stream2 = Arrays.stream(ii);
		
		
		Stream<String> stream3 = Stream.of("a","b","cc","DD","FF");
		
		
		
		Stream<Integer> stream4 = Stream.iterate(0, (x) -> x+2 );
		stream4.limit(100)
		.forEach(System.out::println);
		
		Stream<Double> stream5 = Stream.generate(() -> Math.random());
		stream5.limit(3).forEach(System.out::println);
		
		
		
		
		
		
	}

}
