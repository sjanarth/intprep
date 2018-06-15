package com.intprep;

public class SortInsertion 
{
	private static int[] sort (int[] input)	{
		for (int i = 1; i < input.length; i++)	{
			int k = input[i];
			int j = i-1;
			while (j >= 0 && input[j] > k)	{
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = k;
			debug (input, i);	
		}
		return input;
	}
	
	private static void debug (int[] input, int i)	{
		System.out.print("(");
		for (int j = 0; j <= i; j++)	{
			System.out.print(" "+input[j]);
		}
		System.out.print(") (");
		for (int j = i+1; j < input.length; j++)	{
			System.out.print(" "+input[j]);
		}
		System.out.println(" )");
	}
	
	private static void printArray (String s, int[] arr) {
		System.out.print(s+":");
		for (int i : arr)
			System.out.print(" "+i);
		System.out.println ();
	}
	
	public static void main (String[] args)	{
		int[] input = new int[] { 31, 3, 42, -5, 8, 6, 1, 49, 888, 91};
		printArray("input", input);
		printArray("output", sort(input));
	}
}
