package com.intprep.sort;

public class BubbleSorter extends AbstractSorter 
{
	@Override
	public int[] sort (int[] input)	{
		for (int i = 0; i < input.length-1; i++)	{
			boolean swap = false;
			int j = 0;
			for (; j < input.length-i-1; j++)	{
				if (input[j] > input[j+1])	{
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
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