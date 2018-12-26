package com.intprep.sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class KWayMerge 
{
	private static int[] mergeKWay (int[][] arr) {
		boolean ascend = isAscending (arr);
		System.out.println("isAscending: "+ascend);
		int k = arr.length;
        int[] curr = new int[k];
        Arrays.fill(curr,0);
        List<Integer> outList = new ArrayList<Integer>();
        while (true)   {
            int next = ascend ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int which = -1;
            for (int i = 0; i < k; i++) {
            	if (arr[i].length == curr[i])	// this list is already fully merged
            		continue;
                if ((ascend && next > arr[i][curr[i]]) ||
                    (!ascend && next < arr[i][curr[i]]))    {
                    next = arr[i][curr[i]];
                    which = i;
                }
            }
            if (which != -1)    {
            	outList.add(next);
                curr[which]++;
            } else {
            	break;
            }
        }
        for (int i = 0; i < k; i++)	{
        	if (arr[i].length != curr[i])	{
        		for (int j = curr[i]; j < arr[i].length; j++)	{
        			outList.add(arr[i][j]);
        		}
        	}
        }
        int[] outArr = new int[outList.size()];
        for (int i = 0; i < outList.size(); i++)
        	outArr[i] = outList.get(i);
        return outArr;
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
		int[] output = mergeKWay(ascend);
		System.out.print("Merged: ");
		for (int i : output)
			System.out.print(" "+i);
	}
}
