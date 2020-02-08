package com.intprep.arrays;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * 
 * Note:
 * 
 * You must do this in-place without making a copy of the array. 
 * Minimize the total number of operations.
 * 
 */

public class MoveZeroes extends AbstractArraysProblem
{
	public static void main  (String[] args)	{
		int[] input = initRandomNumericArrayHalfZeroes(10);
		printArray ("input", input);
		moveZeroes(input);
		printArray("output", input);
	}
	
	private static void moveZeroes(int[] input)	{
		int pos = 0;
		for (int i = 0; i < input.length; i++)	{
			if (input[i] != 0)	{
				swap(input,i, pos);
				pos++;
			}
			//System.out.println("i="+i+",pos="+pos+",input="+Arrays.toString(input));
		}
	}
	
	private static void moveZeroes2 (int[] input)	{
		int pos = 0;
		for (int num : input) {
			if (num != 0) 
				input[pos++] = num;
		}
		while (pos < input.length)
			input[pos++] = 0;
	}
}