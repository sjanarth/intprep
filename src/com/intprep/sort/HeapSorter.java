package com.intprep.sort;

public class HeapSorter extends AbstractSorter 
{
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
	
	private void swap (int[] input, int i1, int i2)	{
		int t = input[i1];
		input[i1] = input[i2];
		input[i2] = t;
	}
	
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
}
