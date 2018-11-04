package com.intprep.sort;

public class SelectionSorter extends AbstractSorter 
{
	public int[] sort (int[] input)	{
		for (int i = 0; i < input.length-1; i++)	{
			int min = input[i];
			for (int j = i+1; j < input.length; j++)	{
				if (min > input[j])	{
					input[i] = input[j];
					input[j] = min;
					min = input[i];
				}
			}
			debug (input, i);	
		}
		return input;
	}
}
