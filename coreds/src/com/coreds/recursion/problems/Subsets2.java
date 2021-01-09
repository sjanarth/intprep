package com.coreds.recursion.problems;

import java.util.LinkedHashSet;
import java.util.Set;

public class Subsets2 
{
	public static void main (String[] args) {
		Set<String> all = new LinkedHashSet<>();
		findAllSubsets (all, "", "abcd", 0);
		int i = 1;
		for (String s : all)	
			System.out.println(i+++ ": {"+s+"}");
	}
	
	private static void findAllSubsets (Set<String> all, String current, String input, int start)	{
		all.add(current);
		for (int i = start; i < input.length(); i++)	{
			current = current + input.charAt(i);
			findAllSubsets (all, current, input, i+1);
			current = current.substring(0, current.length()-1);	// current.remove(input[j]) could target multiple elements in current
		}
	}
}
