package com.coreds.sorting.core;

public class BubbleSorter extends AbstractSorter 
{
	@Override	
	public int[] sort (int[] input)	{
		for (int i = input.length-1; i >= 0; i--)	{
			for (int j = i-1; j >= 0; j--)	{
				if (input[i] < input[j])	
					swap(input, i, j);
			}
			printArray("", input);
		}
		return input;
	}
	
	public int[] sort2 (int[] input)	{
		for (int i = 0; i < input.length-1; i++)	{
			boolean swap = false;
			int j = 0;
			for (; j < input.length-i-1; j++)	{
				if (input[j] > input[j+1])	{
					swap(input, j, j+1);
					swap = true;
				}
			}
			debug (input, j-1);
			if (!swap)
				break;
		}
		return input;
	}
}