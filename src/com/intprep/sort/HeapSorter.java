package com.intprep.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter extends AbstractSorter {
	
	private class MinHeap {
		List<Integer> data = new ArrayList<Integer> ();
		public void insert (int k) {
			data.add(k);
			int i = data.size()-1;
			while (i/2 >= 0 && data.get(i) < data.get(i/2))	{
				int t = data.get(i);
				data.set(i, data.get(i/2));
				data.set(i/2, t);
				i = i / 2;
			}
		}
		public int min ()	{
			return data.get(0); 
		}
		public void deleteMin ()	{
		}
		public int[] getData ()	{
			int[] output = new int[data.size()];
			for (int i = 0; i < data.size(); i++)
				output[i] = data.get(i);
			return output;
		}
	}
	
	private class MaxHeap 	{
		List<Integer> data = new ArrayList<Integer> ();
		public void insert (int k) {
			
		}
		public int max ()	{
			return data.get(0); 
		}
		public void deleteMax ()	{
			
		}
	}

	@Override
	protected int[] sort(int[] input) {
		MinHeap heap = new MinHeap();
		for (int i = 0; i < input.length; i++)
			heap.insert(input[i]);
		printArray ("Heap: ", heap.getData());	
		return input;
	}
}