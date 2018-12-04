package com.intprep.sorting.core;

public class QuickSorter extends AbstractSorter
{
	@Override
	public int[] sort (int[] input)	{
		quickSort (input, 0, input.length-1);
		return input;
	}
	
	private void quickSort (int[] input, int left, int right)	{
		int index = partition (input, left, right);
		if (left < index - 1)
			quickSort(input, left, index-1);
		if (index < right)
			quickSort(input, index, right);
	}
	
	private int partition (int[] input, int left, int right)	{
		int i = left, j = right;
		int pivotind = (left+right)/2;
		int pivotval = input[pivotind];
		while (i <= j)	{
			while (input[i] < pivotval) i++;
			while (input[j] > pivotval) j--;
			if (i <= j)	{
				swap(input, i, j);
				i++;
				j--;
			}
		}
		return i;
	}	
}