package com.practice.lambda.unit1.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Charles","Dickens",10),
				new Person("Lewis","Carroll",11),
				new Person("Thomas","Carlyle",12),
				new Person("Charlotte","Bronte",12),
				new Person("Matthew","Arnold",12)
				);
				

		//Step 1: Sort list by last name
		people.sort((p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//Step 2: Create a method that prints all elements in the list
		
		System.out.println("----Printing All People----");
		printConditionally(people, p -> true);		
		
		
		//Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("----Printing All People Last Name Starting With C----");
		printConditionally(people, p -> p.getLastName().startsWith("C"));	
		
	}

	public static void printConditionally(List<Person> people, TestCondition condition){
		for(Person p:people){
			if(condition.test(p)){
				System.out.println(p);
			}
		}
	}
		
		@FunctionalInterface
		interface TestCondition{
			public boolean test(Person person);
		}
	}

