package com.practice.lambda.unit2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.practice.lambda.unit1.exercise.Person;

public class OOBFunctionalInterface {
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
		printConditionally(people, p -> true, p -> System.out.println(p));		
		
		
		//Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("----Printing All People Last Name Starting With C----");
		printConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p.getLastName()));	
		
	}

	//Predicate - Out of the box functional interfaces in the java.util package
	public static void printConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> consume){
		for(Person p:people){
			if(condition.test(p)){
				consume.accept(p);
			}
		}
	}
	
}
