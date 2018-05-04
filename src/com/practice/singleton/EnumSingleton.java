package com.practice.singleton;


public enum EnumSingleton {
	INSTANCE;
	
	private EnumSingleton(){
		System.out.println();
	}
}
