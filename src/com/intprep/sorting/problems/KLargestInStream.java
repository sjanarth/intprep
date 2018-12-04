package com.intprep.sorting.problems;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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
	
	public static void main (String[] args)	{
		int[] output = topK (new int[] {25,15,4,3,100,90,80,75,56,42,11,9,92,43,31}, 5);
		for (int i : output)
			System.out.print(i+" ");
	}
}