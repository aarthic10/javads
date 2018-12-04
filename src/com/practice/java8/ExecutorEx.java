package com.practice.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorEx {

	public static void main(String[] args) {
		
		
		//ExecutorService and Runnable
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		   
		});

		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/* ExecutorService and Callable - callable is similar to runnable but instead of being void it
		returns a value */
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(3);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};
		
		ExecutorService service2 = Executors.newFixedThreadPool(1);
		
		/*Since the submit method cannot wait till the task thread returns a value, it returns 'Future'
		 Future is used to get the result later when the task completes*/
		Future<Integer> future = service2.submit(task);
		System.out.println("Future is done? "+future.isDone());
		
		//Future is tightly coupled. since the executor is not completed. Future will throw error.
		//service2.shutdownNow();
		
		try {
			Integer value = future.get();
			
			//to test future timeout 
			//Integer value = future.get(1, TimeUnit.SECONDS);
			
			System.out.println("Future is done? "+future.isDone());
			System.out.println("Future value "+value);
			
			
			
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Get method blocks till we get the result
 
		
	}

}
