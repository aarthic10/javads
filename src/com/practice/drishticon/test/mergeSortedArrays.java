package com.practice.drishticon.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mergeSortedArrays {

	public static void main(String args[]) {
		Integer[] a = new Integer[] { 1, 3, 5, 7 };
		Integer[] b = new Integer[] { 2, 4, 6, 7, 10, 12 };
		//collectionMerge(a, b);
		//merge(a, b);
		//optimisedMerge(a,b);
		
		Integer[] ar = new Integer[] { 1, 3, 5, 7, 0, 0, 0, 0, 0, 0 };
		mergeInplace(ar,b,3);

	}

	private static void mergeInplace(Integer[] a, Integer[] b,int i) {
		int j = b.length-1;
		int curr = a.length-1;
		while(j>=0){
			if(a[i]>b[j]){
				a[curr--] = a[i--];
			}else{
				a[curr--] = b[j--];
			}
		}
		
		System.out.println(a);
	}

	private static void merge(Integer[] a, Integer[] b) {
		
		int size = a.length + b.length;
		Integer[] c = new Integer[size];
		int i = 0;
		int j = 0;
		for (int pos = 0; pos < size; pos++) {

			if (j == b.length) {
				c[pos] = a[i];
				i++;
			} else if (i == a.length) {
				c[pos] = b[j];
				j++;
			} else {
				if ((a[i] <= b[j])) {
					c[pos] = a[i];
					i++;
				} else {
					c[pos] = b[j];
					j++;
				}
			}
		}
		System.out.println(c);

	}
	
private static void optimisedMerge(Integer[] a, Integer[] b) {
		
		int size = a.length + b.length;
		Integer[] dest = new Integer[size];
		int aPos = 0;
		int bPos = 0;
		int destPos = 0;
		while(aPos<a.length && bPos<b.length) {
				if ((a[aPos] <= b[bPos])) {
					dest[destPos] = a[aPos];
					aPos++;
				} else {
					dest[destPos] = b[bPos];
					bPos++;
				}
			destPos++;
		}
		if (bPos == b.length) {
			System.arraycopy(a, aPos, dest, destPos, a.length-aPos);
		} else if (aPos == a.length) {
			System.arraycopy(b, bPos, dest, destPos, b.length-bPos);
		} 
		System.out.println(dest);

	}

	private static void collectionMerge(Integer[] a, Integer[] b) {

		List<Integer> aList = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> bList = new ArrayList<Integer>(Arrays.asList(b));

		aList.addAll(bList);
		Collections.sort(aList);
		System.out.println(aList);
	}
}
