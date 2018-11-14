package com.intprep.sort.problems;

import java.util.HashSet;
import java.util.Set;

public class NutsAndBolts // needs review
{
	private static String[] groupNutsAndBolts(int[] nuts, int[] bolts) {
		Set<Integer> boltsSet = new HashSet<Integer>();
		for (Integer b : bolts)
			boltsSet.add(b);
		Set<String> outSet = new HashSet<String>();
		for (int n : nuts)	{
			if (boltsSet.contains(n))
				outSet.add(n+" "+n);
		}
		return outSet.toArray(new String[0]);
	}
	
	public static void main (String[] args) {
		int[] NUTS = new int[] {4, 32, 5, 7};
		int[] BOLTS = new int[] {32, 7, 5, 4};
		String[] output = groupNutsAndBolts (NUTS, BOLTS);
		for (String s : output)
			System.out.println(s);
	}
}
