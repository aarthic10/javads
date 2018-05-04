package com.practice.singleton;

public class BreakSingletonCloning {

	public static void main(String args[]){
		Singleton singleton = Singleton.getInstance();
		
		// When the singleton object extends to an cloneable object we can break it with clone method
		Parent parent = (Parent)singleton.clone();
		
		
		
	}
}
