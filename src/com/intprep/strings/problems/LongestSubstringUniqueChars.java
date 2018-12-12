package com.intprep.strings.problems;

import java.util.Set;

import com.intprep.strings.core.StringUtils;

public class LongestSubstringUniqueChars 
{
	public static void main (String[] args) {
		printLongestSubstrOfUniqChars ("helloworld");
		printLongestSubstrOfUniqChars ("helloworld", 2);
	}
	
	private static void printLongestSubstrOfUniqChars (String input) {
		Set<String> substrings = StringUtils.getAllSubstrings(input);
		String longestUniq = null;
		int lengthOfLongest = Integer.MIN_VALUE;
		for (String s : substrings) {
			if (StringUtils.isAllUniqueChars(s) && lengthOfLongest < s.length())	{
				longestUniq = s;
				lengthOfLongest = s.length();
			}
		}
		System.out.println("Longest substring of ["+input+"] containing only unique chars is ["+longestUniq+"]");
	}

	private static void printLongestSubstrOfUniqChars (String input, int uniq_allowed) {
		Set<String> substrings = StringUtils.getAllSubstrings(input);
		String longestUniq = null;
		int lengthOfLongest = Integer.MIN_VALUE;
		for (String s : substrings) {
			if (StringUtils.getCountOfUniqChars(s) <= uniq_allowed && lengthOfLongest < s.length())	{
				longestUniq = s;
				lengthOfLongest = s.length();
			}
		}
		System.out.println("Longest substring of ["+input+"] containing at most "+uniq_allowed+" unique chars is ["+longestUniq+"]");
	}
	
}
