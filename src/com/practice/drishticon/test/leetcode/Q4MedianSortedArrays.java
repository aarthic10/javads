package com.practice.drishticon.test.leetcode;

public class Q4MedianSortedArrays {

	public static void main(String args[]) {
		int nums1[] = new int[] { 1, 3 };
		int nums2[] = new int[] { 2 };

		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int totalLength = nums1.length + nums2.length;
		int[] medians;
		int medianPos1 = totalLength / 2;
		if (totalLength % 2 == 0) {
			medians = new int[2];
			medians[0] = medianPos1;
			medians[1] = medianPos1 + 1;
		} else {
			medians = new int[1];
			medians[0] = medianPos1 + 1;
		}

		double avg = 0;
		int i = 0;
		int j = 0;
		int z = 0;

		for (int medianPos : medians) {
			while (i <= nums1.length -1 || j <= nums2.length-1) {
				z++;
				if(i > nums1.length-1) {
					if (z == medianPos) {
						avg = avg + nums2[j++];
						break;
					}
					j++;
				} else if (j > nums2.length-1) {
					if (z == medianPos) {
						avg = avg + nums1[i++];
						break;
					}
					i++;
				}else if (nums1[i] < nums2[j]) {
					if (z == medianPos) {
						avg = avg + nums1[i++];
						break;
					}
					i++;
				} else if (nums2[j] <= nums1[i]) {
					if (z == medianPos) {
						avg = avg + nums2[j++];
						break;
					}
					j++;
				}
			}
		}

		if(medians.length > 1) {
			avg = avg / 2;
		}
		
		return avg;
	}

}
