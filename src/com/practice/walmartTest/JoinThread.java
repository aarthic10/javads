package com.practice.walmartTest;

public class JoinThread {

	public static void main(String args[]){
		
		Thread t1 = new Thread(){
			public void run(){
				System.out.println("Thread 1 starting");
			}
		};
		
		
		Thread t2 = new Thread(){
			public void run(){
				System.out.println("Thread 2 starting");
			}
		};
		
		
		Thread t3 = new Thread(){
			public void run(){
				System.out.println("Thread 3 starting");
			}
		};
		
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
	}
}
