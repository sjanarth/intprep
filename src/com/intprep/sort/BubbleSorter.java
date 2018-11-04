package com.intprep.sort;

public class BubbleSorter extends AbstractSorter 
{
	public int[] sort (int[] input)	{
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
}