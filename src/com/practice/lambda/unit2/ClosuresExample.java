package com.practice.lambda.unit2;

public class ClosuresExample {

	
	public static void main(String args[]){
		int i=10;
		int b = 20; // Closure : From java 8, b is implicitly final here. 
		
		//Inner class
		doProcess(i, new Process(){
			@Override
			public void process(int i) {
				System.out.println(i * b);
			}			
		});
		
		//Lambda
		doProcess(i, a -> System.out.println(a * b));
	}
	
	public static void doProcess(int i, Process p){
		/* the local variable 'b' is used here even though the variable is not in scope.
		 * A snapshot/value of the variable at the time of passing innerclass/lambda is used here.
		 * b will be 20 here.
		 */
		p.process(i);
	}
}

interface Process{
	void process(int i);
}
