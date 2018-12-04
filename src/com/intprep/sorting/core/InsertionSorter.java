package com.intprep.sorting.core;

public class InsertionSorter extends AbstractSorter 
{
	@Override
	public int[] sort (int[] input)	{
		for (int i = 1; i < input.length; i++)	{
			int k = input[i];
			int j = i-1;
			while (j >= 0 && input[j] > k)	{
				input[j+1] = input[j];
				j--;
			}
			input[j+1] = k;
			debug (input, i-1);	
		}
		return input;
	}
}
