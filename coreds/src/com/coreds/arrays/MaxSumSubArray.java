package com.coreds.arrays;

import java.util.Arrays;

public class MaxSumSubArray 
{
	public static void main(String[] args) 
	{
		findMaxSumSubAray(new int[] {5, 6, 3, -5, 7, 8, 9, -1, 2});
	}
	
	private static void findMaxSumSubAray(int[] input)	{
		int start = -1, end = -1, sum = 0;
		int start2 = -1, end2 = -1, sum2 = 0;
		for (int i = 0; i < input.length; i++)	{
			if (input[i] > 0)	{
				if (start == -1) start = i;
				if (end == -1) end = i;
				sum = sum + input[i];
			} else {
				if (sum > sum2)	{
					start2 = start;
					end2 = i;
					sum2 = sum;
				}
				start = -1;
				end = -1;
				sum = 0;
			}
			System.out.println("    i="+i+",input[i]="+input[i]+",start="+start+",end="+end+", sum="+sum);
		}
		if (sum > sum2)	{
			start2 = start;
			end2 = input.length;
			sum2 = sum;
		}
		System.out.print("findMaxSumSubAray("+Arrays.toString(input)+") = {");
		for (int i = start2; i < end2; i++)
			System.out.print(input[i]+" ");
		System.out.println("}, sum = "+sum2);
	}
}
