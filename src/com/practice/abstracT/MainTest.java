package com.practice.abstracT;

public class MainTest extends AbstractTest{

	public static void main(String args[]){
		AbstractTest test = new MainTest();
		test.concrete();
		System.out.println(test.test);
	}

	@Override
	public String Test() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	

}
