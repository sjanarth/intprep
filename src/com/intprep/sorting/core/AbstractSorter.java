package com.intprep.sorting.core;

public abstract class AbstractSorter 
{
	public void sortMain (int[] input)	{
		System.out.println(this.getClass().getSimpleName());
		printArray("    Input", input);
		long start = System.nanoTime() / 1000;
		int[] output = sort(input);
		long end = System.nanoTime() / 1000;
		printArray("    Output", output);
		System.out.println("    Runtime: "+(end-start)+" us");
	}

	protected abstract int[] sort (int[] input);
	
	protected void debug (int[] input, int i)	{
		/*
		System.out.print("(");
		for (int j = 0; j <= i; j++)	{
			System.out.print(" "+input[j]);
		}
		System.out.print(") (");
		for (int j = i+1; j < input.length; j++)	{
			System.out.print(" "+input[j]);
		}
		System.out.println(" )");
		*/
	}
	
	protected void printArray (String s, int[] arr) {
		System.out.print(s+":");
		for (int i : arr)
			System.out.print(" "+i);
		System.out.println ();
	}
	
	protected void swap (int[] input, int i1, int i2)	{
		int t = input[i1];
		input[i1] = input[i2];
		input[i2] = t;
	}
}