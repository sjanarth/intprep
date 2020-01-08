package com.intprep.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 
{
	public static void main (String[] args) {
		List<List<Character>> subsets = new ArrayList<>(); 
		findAllSubsets (subsets, new ArrayList<Character>(), "abcd".toCharArray(), 0);
		print(subsets);
	}
	
	private static void findAllSubsets (List<List<Character>> allSubsets, List<Character> current, char[] input, int start)	{
		allSubsets.add(new ArrayList<Character>(current));
		for (int i = start; i < input.length; i++)	{
			current.add(input[i]);
			findAllSubsets (allSubsets, current, input, i+1);
			current.remove(current.size()-1);	// current.remove(input[i]) could target multiple elements in current
		}
	}
	
	private static void print (List<List<Character>> subsets)	{
		for (int i = 0; i < subsets.size(); i++)	{
			System.out.print(i+": {");
			for (Character c : subsets.get(i))
				System.out.print(c);
			System.out.println("}");
		}
	}
}
