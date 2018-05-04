package com.practice.walmartTest;

import java.util.concurrent.atomic.AtomicInteger;

public class Deadlock {

	private static AtomicInteger i;
	public static void main(String args[]){
		
		i.getAndIncrement();
		String resource1 = "resource 1";
		String resource2 = "resource 2";
		Thread t1 = new Thread(){
			public void run(){
				synchronized (resource1) {
					System.out.println("Thread 1 - Resource 1 locked");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (resource2) {
						System.out.println("Thread 1 - Resource 2 locked");
					}
				}
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				synchronized(resource2){
					System.out.println("Thread 2 - Resource 2 locked");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					synchronized (resource1) {
						System.out.println("Thread 2 - Resource 1 locked");
					}
				}
			}
			
		};
		t1.start();
		t2.start();
	}
}
