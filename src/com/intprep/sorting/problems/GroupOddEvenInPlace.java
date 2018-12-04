package com.intprep.sorting.problems;

/*
 * You are given an array of non-negative integers only. 
 * Group them in-place into evens and odds in such a way that 
 * all evens appear on the left side and all odds on the right side.
 * 
 * Example:
 * 	Input: 	[1, 2, 3, 4]
 * 	Output:	[2, 4, 1, 3] or [2, 4, 3, 1] or [4, 2, 3, 1]
 *  
 */

public class GroupOddEvenInPlace 
{
	private static void swap (int[] input, int i1, int i2) {
//		System.out.println("Swapping "+i1+" with "+i2);
		int t = input[i1];
		input[i1] = input[i2];
		input[i2] = t;
	}
	
	private static void groupOddEvenInPlace (int[] input)	{
		int oddNext = input.length-1;
		int evenNext = 0;
		while (evenNext < oddNext)	{
			while (((input[oddNext]%2) != 0) && (evenNext < oddNext))	{
				oddNext--;
			}
			while (((input[evenNext]%2) == 0) && (evenNext < oddNext))	{
				evenNext++;
			}
			swap(input, oddNext--, evenNext++);
		}
	}
	
	private static void printArray (String s, int[] arr) {
		System.out.print(s+": ");
		for (int k : arr)
			System.out.print(k+" ");
		System.out.println();
	}
	
	public static void main (String[] args)	{
		int[] input = new int[] {8,4,9,5,2,9,5,7,10};
		printArray("Input", input);
		groupOddEvenInPlace (input);
		printArray("Ouput", input);
	}
}
