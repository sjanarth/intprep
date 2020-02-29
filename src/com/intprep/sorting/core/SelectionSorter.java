package com.intprep.sorting.core;

public class SelectionSorter extends AbstractSorter 
{
	@Override
	public int[] sort (int[] input)	{
		for (int i = 0; i < input.length-1; i++)	{
			for (int j = i+1; j < input.length; j++)	{
				if (input[i] > input[j])	{
					swap(input, i, j);
				}
			}
			debug (input, i);	
		}
		return input;
	}
}
