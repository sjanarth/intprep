package com.intprep.strings.wip;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringUniqueChars 
{
	public static void main (String[] args) {
		findLongestSubstrOfUniqChars ("helloworld", 2);
	}
	
	private static void findLongestSubstrOfUniqChars (String input, int allowed_uniq) {
		char[] inputChars = input.toCharArray();
		Set<Character> uniq = new HashSet<Character>();
		int maxLen = Integer.MIN_VALUE;
		int left = 0, right = 0;
		for (int i = 0; i < inputChars.length; i++) {
			if (uniq.contains(inputChars[i]))	{
				right++;
			} else if (uniq.size() < allowed_uniq)	{
				uniq.add(inputChars[i]);
				right++;
			} else {
				
			}
		}
		String longSubstr =  input.substring(left, right+1);
		System.out.println("Longest substring of ["+input+"] containing just ["+allowed_uniq+"] is ["+longSubstr+"]");
	}
}
