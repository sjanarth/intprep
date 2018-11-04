package com.intprep.sort;

public class SorterTest 
{
	public static void main(String[] args) {
		AbstractSorter sorter = new BubbleSorter ();
		sorter.sortMain();
		sorter = new InsertionSorter ();
		sorter.sortMain();
		sorter = new QuickSorter ();
		sorter.sortMain();
		sorter = new SelectionSorter ();
		sorter.sortMain();
	}
}
