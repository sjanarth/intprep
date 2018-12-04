package com.intprep.sort.problems.wip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
	static String[] findZeroSum(int[] arr) {
		Map<Integer,Integer> input = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			input.put(arr[i], i);
		}
		Set<String> triplets = new HashSet<String>(); 
		for (int i = 0; i < arr.length; i++)	{
			for (int j = 0; j < arr.length; j++)	{
				if (i == j) continue;
				int complementOfSum = -1 * (arr[i]+arr[j]);
				System.out.println("arr[i]="+arr[i]+",arr[j]="+arr[j]+",cOS="+complementOfSum);
				//if (input.contains(complementOfSum))	{
					triplets.add(getString(arr[i],arr[j],complementOfSum));
				//}
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