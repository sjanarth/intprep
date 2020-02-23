package com.intprep.arrays;

import java.util.Arrays;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3081/
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FirstAndLastPositionInSortedArray 
{
	public static void main(String[] args) {
		findTarget(new int[] {5,7,7,8,8,10}, 8);
		findTarget(new int[] {5,7,7,8,8,10}, 6);
	}
	
	private static int[] findTarget (int[] input, int k)	{
		System.out.print("findTarget("+Arrays.toString(input)+") = ");
		int[] retVal = new int[2]; retVal[0] = -1; retVal[1] = -1;
		int ind = binarySearch (input, 0, input.length, k);
		if (ind > -1) {
			int l = ind, r = ind;
			while (l >= 0 && input[l] == k) l--; 
			if (l < 0 || input[l] != k) l++;
			while (r < input.length && input[r] == k) r++; 
			if (r >= input.length || input[r] != k) r--;
			retVal[0] = l; 
			retVal[1] = r;
		}
		System.out.println(Arrays.toString(retVal));
		return retVal;
	}
	
	private static int binarySearch (int[] input, int start, int end, int k)	{
		//System.out.println("start="+start+", end="+end);
		if (start >= end) return -1;
		int mid = start + (end - start) / 2;
		if (input[mid] == k) return mid;
		else if (input[mid] > k) return binarySearch (input, start, mid-1, k);
		else return binarySearch (input, mid, end, k);
	}
}