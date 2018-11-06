package com.intprep.sort;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter extends AbstractSorter 
{
	private abstract class AbstractHeap 
	{
		protected abstract boolean qualifiesAsParent (int parent, int child);
		
		protected AbstractHeap (int[] input) {
			for (int k : input)
				insert(k);
		}
		
		public void insert (int k) {
			// bottom up
			data.add(k);
			//System.out.println(this.getClass().getSimpleName()+": Inserting "+k);
			int i = data.size()-1;
			int parentIndex = (i-1)/2;
			while (parentIndex >= 0 && !qualifiesAsParent (data.get(parentIndex), data.get(i)))		{
				swap (i, parentIndex);
				//HeapSorter.this.printArray("insert, i="+i, getData());
				i = parentIndex;
				parentIndex = (i-1)/2;
			}
		}

		private void swap (int i, int k) {
			int t = data.get(i);
			data.set(i, data.get(k));
			data.set(k, t);
		}
		
		public int deleteTop ()	{
			// top down
			int top = data.get(0);
			//System.out.println(this.getClass().getSimpleName()+": Deleting "+top);
			int size = data.size();
			if (size > 0)	{
				int last = data.remove((data.size()-1));
				if (size > 1)	{
					data.set(0,last);
				}
			}
			int i = 0;
			int newParentIndex = getParentIndex (i, 2*i+1, 2*i+2);
			while (newParentIndex != -1 && newParentIndex != i)	{
				swap (i, newParentIndex);
				i = newParentIndex;
				newParentIndex = getParentIndex (i, 2*i+1, 2*i+2);
			}
			return top;
		}
		
		/*	
		 * Compares a node to its direct descendants (the ones that do exist)
		 * and returns the node most qualified to be the parent  
		 * without over stepping the array bounds.
		 */ 
		private int getParentIndex (int i, int l, int r)	{
			if (i >= data.size())
				return -1;
			if (l < data.size()) {
				if (!qualifiesAsParent(data.get(i), data.get(l)))	{
					if (r < data.size()) {
						return qualifiesAsParent (data.get(l), data.get(r)) ? l : r; 
					} else {
						return l;
					}
				}
			}
			return i;
		}
		
		public int getTop ()	{
			return data.get(0); 
		}

		public int[] getData ()	{
			int[] output = new int[data.size()];
			for (int i = 0; i < data.size(); i++)
				output[i] = data.get(i);
			return output;
		}
		
		public int getSize ()	{
			return data.size();
		}
		
		private List<Integer> data = new ArrayList<Integer> ();
	}
	
	private class MinHeap extends AbstractHeap 	{
		protected MinHeap(int[] input) {
			super(input);
		}
		@Override
		protected boolean qualifiesAsParent(int parent, int child) {
			return parent <= child;
		}
	}

	private class MaxHeap extends AbstractHeap	{
		protected MaxHeap(int[] input) {
			super(input);
		}
		@Override
		protected boolean qualifiesAsParent(int parent, int child) {
			return parent >= child; 
		}
	}
	
	@Override
	protected int[] sort(int[] input) {
		//MinHeap heap = new MinHeap(new int[] {834,510,352,177,59,329,956,649,219,556});
		MinHeap heap = new MinHeap (input);
		//printArray ("MinHeap", heap.getData());
		int size = heap.getSize();
		int[] output = new int[size];
		for (int i = 0; i < size; i++) {
			output[i] = heap.deleteTop();
		}
		return output;
	}
}