package com.intprep.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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
		System.out.println ();
	}
}
