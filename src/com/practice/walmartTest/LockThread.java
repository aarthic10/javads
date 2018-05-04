package com.practice.walmartTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockThread {

	static Lock lock = new ReentrantLock();
	public static void main(String args[]){
		Condition con = lock.newCondition();
	}
	
}
