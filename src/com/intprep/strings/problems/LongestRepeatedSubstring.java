package com.intprep.strings.problems;

import java.util.Set;

import com.intprep.strings.core.StringUtils;

/*
 * Given a string inputStr of length n, find the longest repeated substring in it.
 * 		- Repeated is occurring more than once. 
 * 		- It doesn't matter how many times it occurs as far as it occurs more than once.
 * 		- If there are multiple such substrings of the same size, then return any one.
 * 		- If there are no repeated substrings, then return an empty string.
 *	Example:
 *		Input: aaaa Output: aaa
 *		Input: efabcdhefhabcdiefi Output: abcd
 *	References:
 *		http://www.garretwilson.com/blog/2011/12/15/suffix-trees-java.xhtml
 *		(implements a suffix trie based o(N) solution while the below is a brute force o(N^2) solution)
 */
public class LongestRepeatedSubstring 
{
	public static void main (String[] args) {
		printLongestRepeatedSubstring ("mississippi");
	}
	
	private static void printLongestRepeatedSubstring (String input) {
		Set<String> substrings = StringUtils.getAllSubstrings(input);
		String longestSubstr = null;
		int lengthOfLongest = Integer.MIN_VALUE;
		for (String s : substrings) {
			int count = getNumberOfOccurences (input, s);
			if (count > 1 && lengthOfLongest < s.length())	{
				lengthOfLongest = s.length();
				longestSubstr = s;
			}
		}
		System.out.println("Longest repeated substring ("+input+") is "+longestSubstr);
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
