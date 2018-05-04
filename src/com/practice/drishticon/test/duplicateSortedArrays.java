package com.practice.drishticon.test;

public class duplicateSortedArrays {
	public static void main(String args[]){
		Integer[] a = new Integer[] {21, 22, 34, 35, 41};
		Integer[] b = new Integer[] {11, 21, 34, 45, 61};
		findDuplicates(a,b);
	}

	//similar to merge sorted array. here the lesser values are not moved to another array.
	private static void findDuplicates(Integer[] a, Integer[] b) {
		int i = 0;
		int j = 0;
		int size = a.length > b.length ? a.length : b.length;
		Integer[] duplicates = new Integer[size];
		int pos = 0;
		while(i<a.length && j<b.length){
			if(a[i]<b[j]){
				i++;
			}else if(a[i]>b[j]){
				j++;
			}else{
				duplicates[pos++] = a[i++];
				j++;
			}
		}
		System.out.println(duplicates);
	}
}
