package com.coreds.sorting.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Given K sorted arrays of size N each, merge them and 
 * print the sorted output. Assume N is very large compared to K. 
 * N may not even be known. The arrays could be just sorted streams, 
 * for instance, time stamp streams. All arrays might be sorted in increasing 
 * manner or decreasing manner. Sort all of them in the manner they appear.
 * 
 * Example:
 * Input: 	K = 3, N =  4, arr[][] = { {1, 3, 5, 7}, {2, 4, 6, 8},{0, 9, 10, 11}} 
 * Output:	{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}
 */

public class KWayMerge2
{
	private static int[] mergeKWay (int[][] arr) {
		boolean ascend = isAscending (arr);
		System.out.println("isAscending: "+ascend);
		PriorityQueue<Integer> pq;
		if (ascend)
			pq = new PriorityQueue<Integer>();
		else
			pq = new PriorityQueue<Integer> (arr.length, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++)
				pq.add(arr[i][j]);
		int[] output = new int[pq.size()];
		int curr = 0;
		while (!pq.isEmpty())
			output[curr++] = pq.remove();
		return output;
	}
	
	private static boolean isAscending (int[][] arr) {
		for (int i = 0; i < arr.length; i++)	{
			if (arr[i].length < 2)	{
				continue;
			} 
			for (int j = 1; j <arr[i].length-1; j++) {
				if (arr[i][j-1] < arr[i][j])
					return true;
				else if (arr[i][j-1] > arr[i][j])
					return false;
			}
		}
		return true;
	}
	
	public static void main (String[] args) {
		int[][] ascend = {
				{3,4,15,25},
				{90,100},
				{11,42,56,75,80},
				{9},
				{31,43,92}
			};
		int[][] descend = {
			{25,15,4,3},
			{100,90},
			{80,75,56,42,11},
			{9},
			{92,43,31}
		};
		int[] output = mergeKWay(descend);
		System.out.print("Merged: ");
		for (int i : output)
			System.out.print(" "+i);
	}
}
