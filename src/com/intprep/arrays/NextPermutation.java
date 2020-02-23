package com.intprep.arrays;

import java.util.Arrays;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/59/array-and-strings/3050/
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */

public class NextPermutation 
{
	public static void main(String[] args) {
		nextPermutation(new int[] {1,2,3});
		nextPermutation(new int[] {1,2,3,4});
		nextPermutation(new int[] {1,2,4,3});
		nextPermutation(new int[] {4,3,2,1});
	}
	
	private static void nextPermutation (int[] nums)	{
		System.out.print("nextPermutation("+Arrays.toString(nums)+") = ");
		int i = nums.length-2;
		while (i >= 0 && nums[i] >= nums[i+1]) i--;
		if (i >= 0)	{
			int j = nums.length-1;
			while (j >= 0 && nums[j] <= nums[i]) j--;
			swap(nums, i, j);
        }
        reverse (nums, i+1);
		System.out.println(Arrays.toString(nums));
	}
	
	private static void swap(int[] nums, int i, int j)	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
	
	private static void reverse (int[] nums, int k)	{
		int lo = k, hi = nums.length-1;
		while (lo < hi) {
			swap(nums, lo++, hi--);
		}
	}
}