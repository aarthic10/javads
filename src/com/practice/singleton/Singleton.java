package com.practice.singleton;


public class Singleton extends Parent{

	private volatile static Singleton instance;
	
	private Singleton(){
		System.out.println("created new object");
	}
	
	public static Singleton getInstance(){
		if(instance == null){
			synchronized (Singleton.class) {
				if(instance==null){ //Double checked locking	
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
}
