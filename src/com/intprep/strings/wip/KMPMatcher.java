package com.intprep.strings.wip;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a text string t of length n and a pattern string p of length m, 
 * return start indices of all occurrences of p in t.
 */
public class KMPMatcher 
{
	public static void main (String[] args) {
		matchKMP ("IfyouthinkyouthinktoomuchthenyoumightbewrongThinkaboutit", "you");
	}

	private static int[] matchKMP(String text, String pattern) {
		List<Integer> matches = new ArrayList<Integer>();
		int index = text.indexOf(pattern);
		while (index > -1)	{
			matches.add(index);
			index = text.indexOf(pattern, index+1);
		}
		if (matches.size() == 0) {
			System.out.println("No matches found");
		} else {
			System.out.print("{");
			for (Integer i : matches) System.out.print(i+" ");
			System.out.println("}");
		}
		int[] arr = new int[matches.size()];
		for (int i = 0; i < matches.size(); i++)
			arr[i] = matches.get(i);
		return arr;
	}
}
