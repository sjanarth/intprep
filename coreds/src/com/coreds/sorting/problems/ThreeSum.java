package com.coreds.sorting.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of N integers, find all triplets that sum to 0 (zero).
 * Notes:
 * 	1. Triplets may or may not be consecutive numbers.
 * 	2. The array can include duplicate elements.
 * 	3. Array is not necessarily sorted and may have duplicates.
 * 	4. Print output as shown. i.e. as strings, one per line, comma separated elements.
 * 	5. Order of elements inside the answer triplets does not matter.
 * 	6. Do not print duplicate triplets. Eg: 1,1,-2 and 1,-2,1 are duplicates.
 * 	7. If no such triplets are found, then print nothing.
 * Example:
 * 	Input:	arr = [10, 3, -4, 1, -6, 9];
 * 	Output: {10,-4,-6}, {3,-4,1}	 	
 */

public class ThreeSum 
{
	private static String getString (int a, int b, int c) {
		StringBuilder sb = new StringBuilder("{");
		sb.append(a); sb.append(",");
		sb.append(b); sb.append(",");
		sb.append(c); sb.append("}");
		return sb.toString();
	}
	
	private static String[] findZeroSum(int[] arr) {
		Set<String> triplets = new HashSet<String>();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			int comp = -1 * curr;
			int lo = i+1, hi = arr.length-1;
			while (lo < hi) {
				int sum = arr[lo]+arr[hi]; 
				if (sum == comp)	{
					triplets.add(getString(arr[i], arr[lo], arr[hi]));
					lo++;
				} else if (sum < comp)	{
					lo++;
				} else	{
					hi--;
				}
			}
		}
		return triplets.toArray(new String[0]);
	}
	
	public static void main (String[] args) {
		String[] sums = findZeroSum(new int[] {10,3,-4,1,-6,9});
		for (String s : sums) System.out.println(s);
		sums = findZeroSum(new int[] {3,0,0,0,-3});
		for (String s : sums) System.out.println(s);
	}
}