package com.intprep.recursion.problems;

import java.util.LinkedHashSet;
import java.util.Set;

public class Subsequences 
{
	public static void main (String[] args) {
		Set<String> all = new LinkedHashSet<>();
		findAllSubseqs (all, "abcdefgh");
		int i = 1;
		for (String s : all)	
			System.out.println(i+++ ": {"+s+"}");
	}
	
	private static void findAllSubseqs (Set<String> all, String input)	{
		for (int i = 0; i < input.length(); i++)	{
			String current = input.substring(i, i+1);
			findAllSubseqs (all, current, input, i+1);
		}
	}
	
	private static void findAllSubseqs (Set<String> all, String current, String input, int start)	{
		all.add(current);
		if (start >= input.length())
			return;
		current = current + input.charAt(start);
		findAllSubseqs (all, current, input, start+1);
	}
}
