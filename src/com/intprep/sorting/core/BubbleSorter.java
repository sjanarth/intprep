package com.intprep.sorting.core;

public class BubbleSorter extends AbstractSorter 
{
	@Override	
	public int[] sort (int[] input)	{
		for (int i = input.length-1; i >= 0; i--)	{
			int max = input[i];
			for (int j = 0; j < i; j++)	{
				if (max < input[j])	{
					max = input[j];
					input[j] = input[i];
					input[i] = max;
				}
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