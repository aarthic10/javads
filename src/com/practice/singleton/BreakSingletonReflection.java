package com.practice.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonReflection {

	public static void main(String args[]){
		Singleton singleton = Singleton.getInstance();
		
		
		try {
			
			// Reflection by getClass
			Class<Singleton> reflectionSingleton = (Class<Singleton>) singleton.getClass();
			//Reflection by forName
			Class<Singleton> reflectionSingletonName = (Class<Singleton>) Class.forName("com.practice.singleton.Singleton");
			Constructor[] cons = reflectionSingleton.getDeclaredConstructors();
			
			
			for(Constructor constructor : cons){
				System.out.println("cons");
				constructor.setAccessible(true);
				constructor.newInstance(new Class[0]);
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
