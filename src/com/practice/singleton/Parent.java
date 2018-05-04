package com.practice.singleton;


public class Parent implements Cloneable {
	public Object clone(){
		return new Parent();
	}
}
