package com.practice.walmartTest;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private static int CAPACITY = 1;
	private final Random random = new Random();

	private Lock lock = new ReentrantLock();
	private Condition bufferFull = lock.newCondition();
	private Condition bufferEmpty = lock.newCondition();

	public void put() throws InterruptedException {

		lock.lock();
		try {
			while (list.size() == CAPACITY) {
				System.out.println("Waiting.. Buffer is full");
				bufferFull.await();
			}
			int r = random.nextInt();
			list.add(r);
			System.out.println("Added "+r);
			bufferEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public void take() throws InterruptedException {
		lock.lock();
		try {
			while (list.isEmpty()) {
				System.out.println("Waiting.. Buffer is empty");
				bufferEmpty.await();
			}

			System.out.println("Polled " + list.poll());

			bufferFull.signal();
		} finally {
			lock.unlock();
		}
	}

}
