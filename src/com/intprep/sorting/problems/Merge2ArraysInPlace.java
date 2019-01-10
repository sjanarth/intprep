package com.intprep.sorting.problems;

/*
 * Given two arrays sorted in increasing order:
 * 1) arr1 of size n which contains n positive integers sorted in increasing order.
 * 2) arr2 of size 2n (twice the size of first) which also contains n positive integers 
 * 	  sorted in increasing order in its first half. Second half of this array is empty. 
 *    (Empty elements are marked by 0).
 * Write a function that takes these two arrays, and merges the first one into second one, 
 * resulting in one fully increasingly sorted array of 2n positive integers.
 * 
 * Example:
 * Input: 	n = 3, arr1 = [1 3 5], arr2 = [2 4 6 0 0 0]
 * Output: 	arr2 = [1 2 3 4 5 6]
 */
		
public class Merge2ArraysInPlace
{
    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
    	int n = arr1.length;
    	// Start merging from the end. 
    	int last1 = n - 1;
    	int last2 = n - 1;
    	int last = n + n - 1;
    	// At least one element remaining. 
    	while (last >= 0)	{
    		if (last1 < 0)	{
        		// If no elements remaining in arr1.
    			arr2[last--] = arr2[last2--];
    		} else if (last2 < 0)	{
    			// If no elements remaining in arr2. 
    			arr2[last--] = arr1[last1--];
    		} else if (arr1[last1] <= arr2[last2])	{
        		// Priority to larger element, as we are merging from the end. 
    			arr2[last--] = arr2[last2--];
    		} else	{
    			arr2[last--] = arr1[last1--];
    		}
    	}
    }
	
	public static void main (String[] args) {
		int[] arr1 = new int[] {3,7,9,11,14,22};
		int[] arr2 = new int[] {1,5,9,19,23,36,0,0,0,0,0,0};
		mergeSortedArrays (arr1, arr2);
		for (int m : arr2)
			System.out.print(m+" ");
	}
}