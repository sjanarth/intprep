package com.intprep.recursion.problems;

public class SubsetsAddingToT 
{
	private static boolean addsToT (int[] output, int k, int t) {
		if (k == 0)
			return false;
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum = sum + output[i];
		}
		return sum == t;
	}
	
	private static boolean findIfAnySubsetAddsToT (int[] input, int i, int[] output, int k, int t)	{
		if (i == input.length) {
			return addsToT(output, k, t); 
		} else {
			if (findIfAnySubsetAddsToT(input, i+1, output, k, t))
				return true;
			output[k] = input[i];
			return findIfAnySubsetAddsToT(input, i+1, output, k+1, t);
		}
	}
	
	private static boolean findIfAnySubsetAddsToT (int[] input, int t)	{
		int[] output = new int[input.length];
		return findIfAnySubsetAddsToT (input, 0, output, 0, t);
	}
	
	public static void main (String[] args) {
		System.out.println(findIfAnySubsetAddsToT (new int[] {2,10,20}, 0));
	}
}
