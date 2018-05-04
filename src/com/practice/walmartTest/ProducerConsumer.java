package com.practice.walmartTest;

public class ProducerConsumer {

	public static void main(String args[]){
		
		ProducerConsumerImpl obj = new ProducerConsumerImpl();
		
		Producer producer = new Producer(obj);
		Consumer consumer = new Consumer(obj);
		
		producer.start();
		consumer.start();
		
		
	}
}
