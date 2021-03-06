package com.coreds.strings.wip;

import com.coreds.strings.core.StringUtils;

import java.util.Set;

public class MostRepeatedSubstring 
{
	public static void main (String[] args)	{
		printMostRepeatedSubstring("mississippi");
	}
	
	private static void printMostRepeatedSubstring (String input) {
		Set<String> substrings = StringUtils.getAllSubstrings(input);
		String mostRepeated = null;
		int countOfRepeats = Integer.MIN_VALUE;
		for (String s : substrings)	{
			int count = getNumberOfOccurences (input, s);
			if (count > countOfRepeats) {
				countOfRepeats = count;
				mostRepeated = s;
			}
		}
		System.out.println("Most repeated Substring("+input+") is "+mostRepeated+" which occurs "+countOfRepeats+" times");
	}
	
	private static int getNumberOfOccurences (String input, String substr) {
		int count = 0;
		int index = input.indexOf(substr);
		while (index > -1) {
			count++;
			index = input.indexOf(substr, index+1);
		}
		return count;
	}
}
