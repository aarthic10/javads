package com.practice.singleton;

public class TestSingleton {

	private volatile static TestSingleton _instance;
	
	private TestSingleton(){
		
	}
	
	public TestSingleton getInstance(){
		
		if(null == _instance){
			synchronized (TestSingleton.class) {
				if(null == _instance){
				_instance = new TestSingleton();
				}
			}
			
		}
		
		return _instance;
	}
	
}
