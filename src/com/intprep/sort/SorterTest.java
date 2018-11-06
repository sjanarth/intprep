package com.intprep.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorterTest 
{
	private static List<AbstractSorter> sorters = new ArrayList<AbstractSorter> ();
	static {
		sorters.add(new BubbleSorter());
		sorters.add(new InsertionSorter());
		sorters.add(new SelectionSorter());
		sorters.add(new QuickSorter());
		//sorters.add(new DualPivotQuickSorter());
		sorters.add(new MergeSorter());
		sorters.add(new HeapSorter());
	}
	
	protected static int[] initRandomArray (int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)	{
			arr[i] = (int) (Math.random() * 1000); 
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] original = initRandomArray (10);
		for (AbstractSorter sorter : sorters)	{
			int[] input = Arrays.copyOf(original, 10);
			sorter.sortMain(input);
		}
	}
}
