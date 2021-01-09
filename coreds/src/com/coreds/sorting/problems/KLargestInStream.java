package com.coreds.sorting.problems;

import java.util.*;

/*
 * You are given an array of integers which is analogous to a 
 * continuous stream of input. Find K largest elements from a given 
 * stream of numbers. By definition, we don't know the size of the 
 * input stream. Hence produce K largest elements seen so far, at any 
 * given time. For repeated numbers, return them only once.
 * 
 * If there are less than K unique elements, return all of them.
 * 
 * Example:
 * Input: arr = [1, 5, 4, 4, 2]; k = 2
 * Output: [4, 5]
 */

public class KLargestInStream 
{
	// Time:  o(n2) -- every element is compared with every other
	// Space: o(n)  -- tree set to hold the entire data set in sorted order
	private static int[] topK(int[] arr, int k)	{
		Set<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
		for (int i : arr)
			set.add(i);
		int size = set.size();
		int[] output = new int[k > size ? size : k];
		Iterator<Integer> it = set.iterator();
		for (int i = 0; i < output.length; i++)	{
			output[i] = it.next();
		}
		return output;
	}
	
	// Time:  o(n*k) -- every element is compared with at most K elements
	// Space: o(k)   -- the sliding window only has K elements
	private static int[] topK2(int[] arr, int k) {
		Integer[] result = new Integer[k];
		for (int i = 0; i < k; i++) result[i] = arr[i];
		Arrays.sort(result, Collections.reverseOrder());
		System.out.println(Arrays.toString(result));
		int i = k;
		while (i < arr.length) {
			for (int j = 0; j < k; j++)	{
				if (result[j] < arr[i]) {
					for (int j2 = result.length-1; j2 > j; j2--)	{
						result[j2] = result[j2-1];
					}
					result[j] = arr[i];
					System.out.println(Arrays.toString(result));
					break;
				}
			}
			i++;
		}
		int[] result2 = new int[result.length];
		for (i = 0; i < result.length; i++) result2[i] = result[i];
		return result2;
	}
	
	public static void main (String[] args)	{
		int[] output = topK2 (new int[] {25,15,4,3,100,90,80,75,56,42,11,9,92,43,31}, 5);
		for (int i : output)
			System.out.print(i+" ");
	}
}