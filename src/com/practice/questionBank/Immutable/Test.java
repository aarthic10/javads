package com.practice.questionBank.Immutable;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Age age = new Age();
		age.setDay(14);
		ImmutableTest immutable = new ImmutableTest("Aarthi", age, new Date());
		System.out.println(immutable.getAge().getDay());
		age.setDay(15);
		immutable.getAge().setDay(15);;
		System.out.println(immutable.getAge().getDay());
	}

}
