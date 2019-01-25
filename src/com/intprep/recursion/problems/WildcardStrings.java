package com.intprep.recursion.problems;

import java.util.HashSet;
import java.util.Set;

public class WildcardStrings 
{
	public static void main (String[] args)	{
		wildcardStrings ("1?0?", 0);
	}
	
	private static void wildcardStrings (String s, int k) {
		Set<String> output = new HashSet<String>();
		wildcardStrings(s, k, output);
		for (String s2 : output)
			System.out.println(s2);;
	}
	
	private static void wildcardStrings (String s, int k, Set<String> output) {
		//System.out.println("input="+s+", k="+k);
		char[] input = s.toCharArray();
		for (int i = k; i < input.length; i++)	{
			//System.out.println("    input["+i+"]="+input[i]);
			if (input[i] == '?')	{
				char t = input[i];
				input[i] = '0';
				wildcardStrings(String.valueOf(input), i+1, output);
				input[i] = '1';
				wildcardStrings(String.valueOf(input), i+1, output);
				input[i] = t;
			}
		}
		if (String.valueOf(input).indexOf('?') == -1)	{
			output.add(String.valueOf(input));
		}
	}
}
