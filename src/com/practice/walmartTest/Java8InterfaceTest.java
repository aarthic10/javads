package com.practice.walmartTest;

public class Java8InterfaceTest implements Java8Interface{

	public static void main(String args[]){
		Java8Interface inter = new Java8InterfaceImpl();
		inter.print();
	}
}
