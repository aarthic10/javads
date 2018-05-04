package com.practice.walmartTest;

public class Producer extends Thread {
	
	private ProducerConsumerImpl obj;
	public Producer(ProducerConsumerImpl sharedObj)
	{
		obj = sharedObj;
	}
	public void run(){
		try {
			for(int i=0;i<2;i++)
			obj.put();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
