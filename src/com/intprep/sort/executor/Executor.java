package com.intprep.sort.executor;

import java.util.Arrays;

import com.intprep.sort.AbstractSorter;
import com.intprep.sort.ArraysSorter;
import com.intprep.sort.BubbleSorter;
import com.intprep.sort.HeapSorter;
import com.intprep.sort.InsertionSorter;
import com.intprep.sort.MergeSorter;
import com.intprep.sort.QuickSorter;
import com.intprep.sort.SelectionSorter;

public class Executor 
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
		//new HeapSorter2(),
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
		final int SIZE = 10000;
		int[] original = initRandomArray (SIZE);
		for (AbstractSorter sorter : sorters)	{
			int[] input = Arrays.copyOf(original, SIZE);
			sorter.sortMain(input);
		}
	}
}