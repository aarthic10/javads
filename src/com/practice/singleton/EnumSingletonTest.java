package com.practice.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {

	public static void main(String[] args) {
		EnumSingleton single = EnumSingleton.INSTANCE;
		try {
			Class<EnumSingleton> reflectionSingleton = (Class<EnumSingleton>) single.getClass();//Class.forName("EnumSingleton");
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
		}

	}

}
