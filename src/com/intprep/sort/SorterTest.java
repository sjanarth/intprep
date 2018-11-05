package com.intprep.sort;

import java.util.ArrayList;
import java.util.List;

public class SorterTest 
{
	private static List<AbstractSorter> sorters = new ArrayList<AbstractSorter> ();
	static {
		//sorters.add(new BubbleSorter());
		//sorters.add(new InsertionSorter());
		//sorters.add(new SelectionSorter());
		//sorters.add(new QuickSorter());
		//sorters.add(new DualPivotQuickSorter());
		//sorters.add(new MergeSorter());
		sorters.add(new HeapSorter());
	}
	
	public static void main(String[] args) {
		for (AbstractSorter sorter : sorters)
			sorter.sortMain();
	}
}
