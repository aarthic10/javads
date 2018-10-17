package com.practice.drishticon.test.top30Array.practise;

public class searchArray {
	static int[] arr = {-1, 0, 3, 4, 6, 8 };
	public static void main(String[] args) {
		
		//recursiveSearch(0, arr.length-1, 88);
		recursiveSearchIndex(0, arr.length-1);
	}
	
	public static void recursiveSearch(int startPos, int endPos, int search){
		
		int mid = (startPos + endPos)/2;
		
		if(arr[mid] == search){
			System.out.println("Number found in position "+mid);
			return;
		} else if(endPos <= startPos){
			System.out.println("Number not found in array");
			return ;
		} else if(arr[mid] > search){
			recursiveSearch(startPos, mid-1, search);
		} else if(arr[mid] < search){
			recursiveSearch(mid+1, endPos, search);
		}
		
	}
	
	
	/*Consider a Java or C++ array say X which is sorted and no two elements in it are same. 
	How best can you find an index say i such that element at that index is also i. That is X[i] = i
	eg:
		 Array X : -3 -1 0 3 5 7 
      	 index   :  0  1 2 3 4 5

      Answer is 3 as X[3] = 3.
	*/
	
	public static void recursiveSearchIndex (int startPos, int endPos){
		int mid = (startPos + endPos) / 2;
		if(arr[mid] == mid){
			System.out.println("Found element in position "+mid);
			return ;
		}else if(endPos < startPos || startPos > endPos){
			System.out.println("Element not found ");
			return ;
		} else if(mid < arr[mid]){
			recursiveSearchIndex(startPos, mid+1);
		}	else if(mid > arr[mid]){
			recursiveSearchIndex(mid-1, endPos);
		}
		
	}

}
