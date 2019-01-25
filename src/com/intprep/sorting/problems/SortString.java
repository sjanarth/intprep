package com.intprep.sorting.problems;

public class SortString 
{
	public static void main (String[] args)	{
		sortString("azbycxdw");
	}
	
	private static void sortString(String s)	{
		char[] input = s.toCharArray();
		quickSort (input, 0, input.length-1);
		System.out.println("sortString("+s+") = "+String.valueOf(input));
	}
	
	private static void quickSort (char[] input, int start, int end) {
		int index = partition(input, start, end);
		if (start < index-1) 
			quickSort(input, start, index-1);
		if (index < end) 
			quickSort(input, index, end);
	}
	
	private static int partition(char[] input, int start, int end) {
		int i = start, j = end;
		int pi = (i+j)/2;
		int pv = input[pi];
		while (i <= j) {
			while (input[i] < pv) i++;
			while (input[j] > pv) j--;
			if (i <= j)	{
				swap(input, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	private static void swap(char[] input, int i, int j)	{
		char t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
}
