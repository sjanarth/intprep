package com.intprep;

public class SortQuick {

	private static int partition (int[] input, int left, int right)	{
		int i = left, j = right;
		int pivot = input[(left+right)/2];
		while (i <= j)	{
			while (input[i] < pivot) i++;
			while (input[j] > pivot) j--;
			if (i <= j)	{
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	private static void quickSort (int[] input, int left, int right)	{
		int index = partition (input, left, right);
		if (left < index - 1)
			quickSort(input, left, index-1);
		if (index < right)
			quickSort(input, index, right);
	}
	
	private static int[] sort (int[] input)	{
		quickSort (input, 0, input.length-1);
		return input;
	}
	
	private static void debug (String s)	{
		System.out.println(s);
	}
	
	private static void printArray (String s, int[] arr) {
		System.out.print(s+":");
		for (int i : arr)
			System.out.print(" "+i);
		System.out.println ();
	}
	
	public static void main (String[] args)	{
		int[] input = new int[] { 31, 3, 42, -5, 8, 6, 1, 49, 888, 91};
		printArray("input", input);
		printArray("output", sort(input));
	}
}
