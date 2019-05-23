package com.jemson.test.testjdk8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		//Optional<T>
		//Optional<Student> optional = Optional.of(new Student());
//		Optional<Student> optional = Optional.empty();
		Optional<Student> optional = Optional.ofNullable(new Student("jemson",12));
		if(optional.isPresent()) {
			System.out.println(optional.get()); 
			
		}
		

		Optional<String> op2 = optional.map(e -> e.getName());
		
		if(op2.isPresent()) {
			System.out.println(op2.get()); 
			
		}
		
		
		
		
		
		
		Optional<Student> op3 = Optional.empty();
		
		
		
		
	}

}
