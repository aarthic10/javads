package com.practice.drishticon.test;

public class ArrayEx {
	
	
	public static void main(String args[]) {
		

		 int array[][] = new int[][]{
		 {1, 1, 1, 0},
		 {1, 1, 1, 0},
		 {0, 1, 1, 1}
		 };
		 
//		int[][] a = new int[][] { { 0, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		 
		 PathCalculator calculator = new PathCalculator();
		 int paths = calculator.calculateTotalPaths(array);
		 System.out.println("All Paths Found");
		 System.out.println("Total Number of Paths : " + paths);

		}
}