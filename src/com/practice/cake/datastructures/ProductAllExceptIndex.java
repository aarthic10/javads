package com.practice.cake.datastructures;

public class ProductAllExceptIndex {

	public static void main(String[] args) {
		int[] numbers = new int[] { 0, 3, -7, 1 };

		//getProductsOfAllIntsExceptAtIndex(numbers);
		int[] allProducts = getProductsWithDivision(numbers);
		for(int i : allProducts){
			System.out.print(i +" ");
		}
	}

	public static int[] getProductsWithDivision(int[] intArray) {
		
		if (intArray.length < 2) {
			throw new IllegalArgumentException(
					"Getting the product of numbers at other indices requires at least 2 numbers");
		}
		
		
		int totalProduct = 1;
		
		int zeroIndex = -1;		
		
		for(int i=0; i<intArray.length; i++){
			if(intArray[i] == 0){
				if(zeroIndex!=-1){
					totalProduct = 0;
					break;
				}else{
					zeroIndex = i;
					continue;
				}
			}else{
				totalProduct *= intArray[i];
			}
		}
		
		int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
		
		if(zeroIndex!=-1){
			productsOfAllIntsExceptAtIndex[zeroIndex] = totalProduct;
			return productsOfAllIntsExceptAtIndex;
		}
		
		for(int i=0; i<intArray.length; i++){
			productsOfAllIntsExceptAtIndex[i] = totalProduct / intArray[i];
		}
		
		return productsOfAllIntsExceptAtIndex;
		
	}
	
	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

		if (intArray.length < 2) {
			throw new IllegalArgumentException(
					"Getting the product of numbers at other indices requires at least 2 numbers");
		}

		// we make an array with the length of the input array to
		// hold our products
		int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

		// for each integer, we find the product of all the integers
		// before it, storing the total product so far each time
		int productSoFar = 1;
		for (int i = 0; i < intArray.length; i++) {
			productsOfAllIntsExceptAtIndex[i] = productSoFar;
			productSoFar *= intArray[i];
		}

		// for each integer, we find the product of all the integers
		// after it. since each index in products already has the
		// product of all the integers before it, now we're storing
		// the total product of all other integers
		productSoFar = 1;
		for (int i = intArray.length - 1; i >= 0; i--) {
			productsOfAllIntsExceptAtIndex[i] *= productSoFar;
			productSoFar *= intArray[i];
		}

		return productsOfAllIntsExceptAtIndex;
	}
}
