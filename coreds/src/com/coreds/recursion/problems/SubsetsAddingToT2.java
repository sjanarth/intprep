package com.coreds.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class SubsetsAddingToT2 
{
	public static void main (String[] args) {
		findSubsetsAddingToT (new int[] {2,5,10,12}, 17);
	}

	private static void findSubsetsAddingToT (int[] input, int t)	{
		List<List<Integer>> all = new ArrayList<>();
		findSubsetsAddingToT (input, t, all, new ArrayList<Integer>(), 0);
		for (List<Integer> sub : all) {
			System.out.println(sub.toString());
		}    	
	}
	
	private static void findSubsetsAddingToT (int[] input, int t, List<List<Integer>> all, List<Integer> current, int start)	{
		if (t == 0) {
			all.add(new ArrayList<Integer>(current));
			return;
		}
		if (start == input.length) 
			return;
		for (int i = start; i < input.length; i++) {
			if (input[i] > t) continue;
			current.add(input[i]);
			findSubsetsAddingToT(input, t-input[i], all, current, i+1);
			current.remove(current.size()-1);
		}
	}
}