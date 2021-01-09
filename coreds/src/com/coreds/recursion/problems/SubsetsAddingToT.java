package com.coreds.recursion.problems;

public class SubsetsAddingToT 
{
	public static void main (String[] args) {
		System.out.println(findIfAnySubsetAddsToT (new int[] {2,10,12}, 14));
	}

	private static boolean findIfAnySubsetAddsToT (int[] input, int t)	{
		int[] output = new int[input.length];
		return findIfAnySubsetAddsToT (input, 0, output, 0, t);
	}
	
	private static boolean findIfAnySubsetAddsToT (int[] input, int i, int[] output, int k, int t)	{
		if (i == input.length) {
			boolean yes = addsToT(output, k, t);
			if (yes)	
				print (output, k);
			return yes;
		} else {
			if (findIfAnySubsetAddsToT(input, i+1, output, k, t))
				return true;
			output[k] = input[i];
			return findIfAnySubsetAddsToT(input, i+1, output, k+1, t);
		}
	}
	
	private static boolean addsToT (int[] output, int k, int t) {
		if (k == 0)
			return false;
		int sum = 0;
		for (int i = 0; i < k; i++) 
			sum = sum + output[i];
		return sum == t;
	}
	
	private static void print (int[] output, int k) {
		System.out.print("{"+output[0]);
		for (int i = 1; i < k; i++)
			System.out.print(","+output[i]);
		System.out.println("}");
	}
}