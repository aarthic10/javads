package com.practice.walmartTest;

public class MaximumSumSubArray {

	
	public static void main(String args[]){
		
		int[] arr = new int[]{-5,-4,-2,-9,-3,-4};
		
		int i=0,j=1,sum=arr[i],actualSum=Integer.MIN_VALUE;
		while(i<arr.length-1){
			
			if(j==arr.length){
				i++;
				j=i+1;
				sum=arr[i];
			}else{
				sum = sum+arr[j];
				if(sum>=actualSum){
					System.out.println("i "+i+" j "+j+" sum "+sum);
					actualSum = sum;
				}
				j++;
			}
		}
		
		System.out.println(actualSum);
		
		System.out.println(maxSubArraySum(arr));
	}
	
	
	
	 static int maxSubArraySum(int a[])
	    {
	        int size = a.length;
	        int actualSum = Integer.MIN_VALUE, sum = 0;
	 
	        for (int i = 0; i < size; i++)
	        {
	            sum = sum + a[i];
	            if (actualSum < sum)
	                actualSum = sum;
	            if (sum < 0)
	                sum = 0;
	        }
	        return actualSum;
	    }
}
