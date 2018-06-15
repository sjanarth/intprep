package com.intprep;

public class SortBubble {

	private static int[] sort (int[] input)	{
		for (int i = 0; i < input.length-1; i++)	{
			boolean swap = false;
			for (int j = 0; j < input.length-i-1; j++)	{
				if (input[j] > input[j+1])	{
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
					swap = true;
				}
			}
			debug (input, i);
			if (!swap)
				break;
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
