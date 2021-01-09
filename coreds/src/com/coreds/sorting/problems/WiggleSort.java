package com.coreds.sorting.problems;

/*
 * Given an unsorted array nums, reorder it in-place such that 
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * Example:
 * 	Input: nums = [3,5,2,1,6,4]
 * 	Output: One possible answer is [3,5,1,6,2,4]
 */
public class WiggleSort 
{
	public static void main (String[] args) {
		int[] input = initRandomArray ();
		printArray("Input", input);
		wiggleSort(input);
		printArray("Output", input);
	}
	
	private static int[] initRandomArray()	{
		final int SIZE = 10;
		int[] arr = new int[SIZE];
		for (int i = 0; i < SIZE; i++)	{
			arr[i] = (int) (Math.random()*100);
		}
		return arr;
	}
		
	private static void printArray (String s, int[] input)	{
		StringBuilder sb = new StringBuilder(s);
		sb.append(" {");
		for (int i : input) sb.append(i+",");
		sb.append("}");
		System.out.println(sb.toString());
	}

	private static void wiggleSort (int[] input) {
		for (int i = 1; i < input.length; i+= 2) {
			if(input[i-1] > input[i]) {
				swap(input, i-1, i);
			}
			if ((i+1) < input.length && input[i+1] > input[i]) {
				swap(input, i, i+1);
			}
		}
	}
	
	private static void swap (int[] input, int i, int j) {
		int t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
}
