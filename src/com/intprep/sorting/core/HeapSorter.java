package com.intprep.sorting.core;

public class HeapSorter extends AbstractSorter 
{
	@Override
	protected int[] sort(int[] input) {
		int size = input.length;
		for (int i=size/2-1; i >= 0; i--)
			heapify (input, size, i);
		//printArray ("MaxHeap", input);
		for (int i = size-1; i >= 0; i--)	{
			swap (input, i, 0);
			heapify (input, i, 0);
		}
		return input;
	}
	
	private void heapify (int[] input, int n, int i) {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && input[left] > input[max])		// is left > root? 
			max = left; 
		if (right < n && input[right] > input[max]) 	// if right > larger (left, root)
			max = right; 
		if (max != i)	{								
			swap (input, i, max);
			heapify (input, n, max);					// recursively heapify the affected sub tree
		}
	}
}
