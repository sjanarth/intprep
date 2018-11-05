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
		int l = 0, r = 0, curr = 0;
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
		if (start < end) {
			int mid = (start+end)/2;
			//debug (input, mid);	
			mergeSort (input, start, mid);
			mergeSort (input, mid+1, end);
			merge (input, start, mid, end);
		}
	}
	
	@Override
	protected int[] sort(int[] input) {
		mergeSort (input, 0, input.length-1);
		return input;
	}
}
