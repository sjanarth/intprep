package com.intprep.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EqualSubsets 
{
	public static void main (String[] args) {
		findEqualSubsets (new Integer[] {3,5,6,9,12,18});
		findEqualSubsets (new Integer[] {3,5,6,9,12,27});
		findEqualSubsets (new Integer[] {3,5,6,9,12,19});
		findEqualSubsets (new Integer[] {3,3,6,12});
	}
	
	private static void findEqualSubsets (Integer[] arr) {
		System.out.println("Equal subsets ("+toString(arr)+"):");
		int sum = getSum (arr);
		if ((sum%2) == 1) {
			System.out.println("Input set adds up to an odd sum");
			return;
		} else {
			List<List<Integer>> eqSubsets = findSubsetsAddingToT(arr, sum/2);
			if (eqSubsets.size() == 0)	{
				System.out.println("No equal subsets found");
			} else { 
				for (List<Integer> ss : eqSubsets) {
					System.out.println(toString(ss.toArray(new Integer[0]))+
										","+
										toString(getDiff(arr, ss)));
				}
			}
		}
	}
	
	private static List<List<Integer>> findSubsetsAddingToT (Integer[] input, int t)	{
		List<List<Integer>> eqSubsets = new ArrayList<List<Integer>>();
		Integer[] output = new Integer[input.length];
		findSubsetsAddingToT (input, 0, output, 0, t, eqSubsets);
		return eqSubsets;
	}
	
	private static boolean findSubsetsAddingToT (Integer[] input, 
													int i, 
													Integer[] output, 
													int k, 
													int t,
													List<List<Integer>> subsets)	{
		if (i == input.length) {
			boolean yes = addsToT(output, k, t);
			if (yes)	{
				List<Integer> ss = new ArrayList<Integer>();
				for (int j = 0; j < k; j++) ss.add(output[j]);
				subsets.add(ss);
			}	
			return yes;
		} else {
			if (findSubsetsAddingToT(input, i+1, output, k, t, subsets))
				return true;
			output[k] = input[i];
			return findSubsetsAddingToT(input, i+1, output, k+1, t, subsets);
		}
	}
	
	private static boolean addsToT (Integer[] arr, int k, int t) {
		int sum = 0;
		for (int i = 0; i < k; i++) sum = sum + arr[i];
		return sum == t;
	}
	
	private static int getSum (Integer[] arr) {
		int sum = 0;
		for (Integer i : arr) sum = sum + i;
		return sum;
	}
	
	private static String toString(Integer[] arr)	{
		return Arrays.toString(arr).
				replaceAll("\\[", "\\{").
				replaceAll("\\]", "\\}").
				replaceAll(" ", "");
	}
	
	private static Integer[] getDiff (Integer[] arr, List<Integer> ss) {
		List<Integer> diff = new ArrayList<Integer>();
		for (Integer i : arr)
			if (!ss.contains(i))
				diff.add(i);
		return diff.toArray(new Integer[0]);
	}
}
