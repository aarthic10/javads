package com.practice.drishticon.test.top30Array.javarevisited;

public class Qn18AlternatePosNeg {

	public static void main(String args[]){
	
		int[] arr = rearrangePosNeg(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
		for(int num:arr){
			System.out.print(num + " ");
		}
		
	}

	private static int[] rearrangePosNeg(int[] arr) {
		int[] negNumbers = new int[arr.length];
		int[] posNumbers = new int[arr.length];
		int negPtr = 0;
		int posPtr = 0;
		
		for(int num:arr){
			if(num<0){
				negNumbers[negPtr] = num;
				negPtr++;
			}else{
				posNumbers[posPtr] = num;
				posPtr++;
			}
		}
		int negSize = negPtr;
		int posSize = posPtr;
		negPtr = 0;
		posPtr = 0;
		int i =0;
		while(negPtr<negSize && posPtr<posSize){
			if(i%2==0){
				arr[i] = negNumbers[negPtr++];
			}else{
				arr[i] = posNumbers[posPtr++];
			}
			i++;
		}
		
		if(negPtr>=negSize){
			System.arraycopy(posNumbers, posPtr, arr, i, posSize-posPtr);
		}else if(posPtr>=posSize){
			System.arraycopy(negNumbers, negPtr, arr, i, negSize-negPtr);
		}
		
		return arr;
	}

	/*private static void rearrangePosNegInPlace(int[] arr) {
		int curr =0,pos = 0,neg = 0;
		while(curr < arr.length){
			if(curr%2==0 && arr[curr]>0){
				while(neg<arr.length){
					if(arr[neg]<0){
						break;
					}
					neg++;
				}
				
				if(neg>arr.length){
					break;
				}else{
					swap()
				}
			}
		}
		
		
	}*/
	
}
