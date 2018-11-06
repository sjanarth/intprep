package com.intprep.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorterTest 
{
	private static List<AbstractSorter> sorters = new ArrayList<AbstractSorter> ();
	static {
		sorters.add(new ArraysSorter());
		sorters.add(new BubbleSorter());
		sorters.add(new InsertionSorter());
		sorters.add(new SelectionSorter());
		sorters.add(new QuickSorter());
		//sorters.add(new DualPivotQuickSorter());
		sorters.add(new MergeSorter());
		sorters.add(new HeapSorter());
		//sorters.add(new HeapSorter2());
	}
	
	protected static int[] initRandomArray (int size) {
		//int[] arr = new int[] {415,389,713,449,874,640,294,528,691,830};
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)	{
			arr[i] = (int) (Math.random() * size * 100); 
		}
		return arr;
	}
	
	public static void main(String[] args) {
		final int SIZE = 10000;
		int[] original = initRandomArray (SIZE);
		for (AbstractSorter sorter : sorters)	{
			int[] input = Arrays.copyOf(original, SIZE);
			sorter.sortMain(input);
		}
	}
}
