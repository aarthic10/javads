package com.practice.drishticon.test.string;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
	
	public static void main(String args[]){
		Integer i = 1;
		Long l = 1L;
		genericTest(i);
	}

	private static <T> void genericTest(Integer elem) {
		List<? extends Integer> numbers = new ArrayList<>();
		
		//numbers.add(elem);
		
	}
}
