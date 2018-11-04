package com.intprep.sort;

public class SorterTest 
{
	public static void main(String[] args) {
		int[] input = {53, 4, 77, 46, 23, 888, 93, 1};
		AbstractSorter sorter = new InsertionSorter ();
		sorter.printArray("Input", input);
		long start = System.currentTimeMillis();
		int[] output = sorter.sort(input);
		long end = System.currentTimeMillis();
		sorter.printArray("Output", output);
		System.out.println("Runtime: "+(end-start));
	}
}
