package com.practice.drishticon.test;


public class PathCalculator {

	private int lastRow;
	private int lastCol;
	private String message;

	public int calculateTotalPaths(int[][] array) {
		lastRow = array.length - 1;
		lastCol = array[0].length - 1;
		return calculate(array, 0, 0, 0);
	}

	public int calculate(int[][] array, int rowIndex, int colIndex, int totalPaths) {

		

		//destination
		if (rowIndex == lastRow && colIndex == lastCol) {
			this.message = "REACHED DESTINATION!!! BACKTRACE TO LAST POSITION";
			displayPosition(array, rowIndex, colIndex);
			++totalPaths;
			System.out.println("PATH : "+totalPaths+"\n");
			return totalPaths;
		}
		
		//Error first and last position blocked. Can't start and reach the end respectively.
		
		if (array[0][0] == 0 || array[lastRow][lastCol] == 0) {
			return 0;
		}

		// Traverse Right
		if (colIndex + 1 <= lastCol && array[rowIndex][colIndex + 1] == 1) {
			this.message="MOVED RIGHT";
			displayPosition(array, rowIndex, colIndex);
			totalPaths = calculate(array, rowIndex, colIndex + 1, totalPaths);
			
		}

		// Traverse Down
		if (rowIndex + 1 <= lastRow && array[rowIndex + 1][colIndex] == 1) {
			this.message = "MOVED DOWN";
			displayPosition(array, rowIndex, colIndex);
			totalPaths = calculate(array, rowIndex + 1, colIndex, totalPaths);
			
		}

		return totalPaths;
	}

	private void displayPosition(int[][] array, int currentRow, int currentCol) {
		int row = 0;
		int col = 0;
		
		for (int[] start : array) {
			for (int pos : start) {

				if (row == currentRow && col == currentCol) {
					System.out.print("A ");
				} else {

					System.out.print(pos + " ");

				}
				col++;
			}
			row++;
			col = 0;
			System.out.println("");
		}
		System.out.println("");
		System.out.println(this.message);
		
	}

}
