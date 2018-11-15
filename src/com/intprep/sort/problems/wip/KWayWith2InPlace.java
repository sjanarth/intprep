package com.intprep.sort.problems.wip;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWayWith2InPlace // needs review
{
	static int partition (int[] arr, int left, int right)	{
		int p = (left+right)/2;
		int pv = arr[p];
		int i = left, j = right;
		while (i <= j)	{
			while (arr[i] < pv) i++;
			while (arr[j] > pv) j--;
			if (i <= j)	{
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j--;
			}
		}
		return i;
	}
	
	static void quickSort (int[] arr, int left, int right) {
		System.out.println("quickSort "+left+","+right);
		int p = partition (arr, left, right);
		System.out.println("p="+p);
		if (left < p-1)
			quickSort (arr, left, p-1);
		if (p < right)
			quickSort (arr, p, right);
	}
	
    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
    	int N = arr1.length;
    	for (int i = N; i < arr2.length; i++)
    		arr2[i] = arr1[i-N];
    	//Arrays.sort(arr2);
    	quickSort (arr2, 0, arr2.length-1);
    	return arr2;
    }
	
	public static void main (String[] args) {
		int[] arr1 = new int[] {3,7,9,11,14,22};
		int[] arr2 = new int[] {1,5,9,19,23,36,0,0,0,0,0};
		merger_first_into_second (arr1, arr2);
		for (int m : arr2)
			System.out.print(m+" ");
	}
}
