package com.practice.lambda.unit1;

public class RunnableLambda {
	public static void main(String args[]){
	
		//Runnable
		Thread myThread = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Running");				
			}
		});
		
		myThread.start();
		
		
		Runnable r = () -> System.out.println("Running");
		Thread lambdaThread = new Thread(r);
		lambdaThread.start();
		
		Thread lambdaThread2 = new Thread(() -> System.out.println("Running"));
		lambdaThread2.start();	
		
		
	}
}
