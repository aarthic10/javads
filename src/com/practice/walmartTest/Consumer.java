package com.practice.walmartTest;

public class Consumer extends Thread{

	private ProducerConsumerImpl obj;
	
	public Consumer(ProducerConsumerImpl sharedObj){
		this.obj = sharedObj;
	}
	
	public void run(){
		try {
			for(int i=0;i<2;i++)
			obj.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
