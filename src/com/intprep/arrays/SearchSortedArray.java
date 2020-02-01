package com.intprep.arrays;

import java.util.Arrays;

public class SearchSortedArray 
{
	public static void main(String[] args) {
		int[][] arrays = new int[][] {
			{5,7,7,8,8,10},
			{5,7,7,8,8,10},
			{1,4}
		};
		int[] targets = new int[] {
			8,
			6,
			4
		};
		for (int i = 0; i < arrays.length; i++)	{
			System.out.println("findRange("+Arrays.toString(arrays[i])+","+targets[i]+") = "+Arrays.toString(findRange(arrays[i], targets[i])));
		}
	}
	
	private static int[] findRange (int[] arr, int k)	{
		return findRange (arr, k, 0, arr.length-1);
	}
	
	private static int[] findRange (int[] arr, int k, int start, int end)	{
		if (start > end)	{
			return new int[] {-1,-1};
		}
		int mid = start + (end-start) / 2;
		if (arr[mid] < k)	{
			return findRange (arr, k, mid+1, end);
		} else if (arr[mid] > k)	{
			return findRange (arr, k, start, mid-1);
		} else {
			int[] ret = new int[2];
			int savedMid = mid;
			while (mid >=0  && arr[mid] == k) mid--;
			ret[0] = mid+1;
			while (savedMid < arr.length && arr[savedMid] == k) savedMid++;
			ret[1] = savedMid-1;
			return ret;
		}
	}
}