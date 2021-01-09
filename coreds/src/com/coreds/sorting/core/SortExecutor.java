package com.coreds.sorting.core;

import java.util.Arrays;

public class SortExecutor 
{
	private static AbstractSorter[] sorters = new AbstractSorter[] {
		new ArraysSorter(),
		new BubbleSorter(),
		new InsertionSorter(),
		new SelectionSorter(),
		new QuickSorter(),
		//new DualPivotQuickSorter(),
		new MergeSorter(),
		new HeapSorter(),
	};
	
	protected static int[] initRandomArray (int size) {
		//int[] arr = new int[] {415,389,713,449,874,640,294,528,691,830};
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)	{
			arr[i] = (int) (Math.random() * size * 100); 
		}
		return arr;
	}
	
	public static void main(String[] args) {
		final int SIZE = 10;
		int[] original = initRandomArray (SIZE);
		for (AbstractSorter sorter : sorters)	{
			int[] input = Arrays.copyOf(original, SIZE);
			sorter.sortMain(input);
		}
	}
}