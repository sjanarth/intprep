package com.intprep.sort;

public class MergeSorter extends AbstractSorter 
{
	private void merge (int[] input, int start, int mid, int end) {
		//System.out.println("merge, start="+start+",mid="+mid+",end="+end);
		// determine the size of the splits
		int n1 = mid - start + 1;
		int n2 = end - mid;
		// initialize the left and right sub arrays
		int[] left = new int[n1];
		for (int i = 0; i < n1; i++)
			left[i] = input[start+i];
		//printArray ("    left", left);
		int[] right = new int[n2];
		for (int i = 0; i < n2; i++)
			right[i] = input[mid+1+i];
		//printArray ("    right", right);		
		// merge the two splits
		int l = 0, r = 0, curr = start;
		while (l < n1 && r < n2)	{
			if (left[l] < right[r])	{
				input[curr++] = left[l++];
			} else {
				input[curr++] = right[r++];
			}
		}
		while (l < n1)	{
			input[curr++] = left[l++];
		}
		while (r < n2) {
			input[curr++] = right[r++];
		}
	}
	
	private void mergeSort (int[] input, int start, int end) {
		if (start >= end)				// practically, this is (start == end || start == end+1)
			return;
		int mid = start+(end-start)/2;	// (start+end)/2 is valid too but could cause an overflow for large data sets
		debug (input, mid);	
		mergeSort (input, start, mid);	// mergeSort(input, start, mid-1)	=>	this would lead to an infinite loop for an array of size 2
		mergeSort (input, mid+1, end);	// mergeSort(input, mid, end)
		merge (input, start, mid, end);
	}
	
	@Override
	protected int[] sort(int[] input) {
		mergeSort (input, 0, input.length-1);
		return input;
	}
}
