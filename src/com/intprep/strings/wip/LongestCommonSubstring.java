package com.intprep.strings.wip;

import java.util.Set;

import com.intprep.strings.core.StringUtils;

public class LongestCommonSubstring 
{
	public static void main (String[] args) {
		printLongestCommonSubstring("call", "ball");
	}
	
	private static void printLongestCommonSubstring (String s1, String s2) {
		Set<String> substrings1 = StringUtils.getAllSubstrings(s1);
		Set<String> substrings2 = StringUtils.getAllSubstrings(s2);
		String longestCommon = null;
		int lengthOfLongest = Integer.MIN_VALUE;
		for (String s : substrings1)	{
			if (substrings2.contains(s) && lengthOfLongest < s.length())	{
				longestCommon = s;
				lengthOfLongest = s.length();
			}
		}
		System.out.println("Longest common substring("+s1+","+s2+")="+longestCommon);
	}
}
