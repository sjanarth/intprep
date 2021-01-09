package com.coreds.recursion.problems;

import java.util.LinkedHashSet;
import java.util.Set;

public class Permutations2 
{
	public static void main(String[] args) {
		Set<String> all = new LinkedHashSet<String>();
		findPermutations (all, "abcd".toCharArray(), 0);
		int i = 0;
		for (String s : all)
			System.out.println(i+++": {"+s+"}");
	}
	
	private static void findPermutations (Set<String> all, char[] input, int start)	{
		if (start == input.length)	{
			all.add(String.valueOf(input));
		}
		for (int i = start; i < input.length; i++)	{
			swap(input, start, i);
			findPermutations (all, input, start+1);
			swap(input, start, i);
		}
	}
	
	private static void swap(char[] input, int i, int j)	{
		char t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
	
}
