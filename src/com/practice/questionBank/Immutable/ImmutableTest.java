package com.practice.questionBank.Immutable;

import java.util.Date;

public final class ImmutableTest {
	
	private final String name;
	private final Age age;
	private final Date date;

	public ImmutableTest(String name, Age age, Date date) {
		this.name = name;
		Age immutableAge = new Age();
		immutableAge.setDay(age.getDay());
		this.age = immutableAge;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		Age cloneAge = new Age();
		 cloneAge.setDay(age.getDay());
		return cloneAge;
	}

	public Date getDate() {
		return date;
	}

}
