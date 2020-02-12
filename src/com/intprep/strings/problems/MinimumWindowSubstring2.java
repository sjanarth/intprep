package com.intprep.strings.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Leetcode #76 Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * Note:
 * 
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * 
 * Reference:
 * http://www.youtube.com/watch?v=0GOyCIJ2ajQ (Amell Peralta)
 * 
 */

public class MinimumWindowSubstring2 
{
	public static void main (String[] args) {
		findMinWindowSubstring("helloworld", "lwr");
		findMinWindowSubstring("ADOBECODEBANC","ABC");
	}

	private static String findMinWindowSubstring (String s, String t) {
		String result = "";
		int[] letterCount = new int[128];
		int left = 0, count = 0, minLen = Integer.MAX_VALUE;
		for (char ch : t.toCharArray())
			letterCount[ch]++;
		for (int right = 0; right < s.length(); right++)	{
			if (--letterCount[s.charAt(right)] >= 0)
				count++;
			while (count == t.length()) {
				if (minLen > right - left + 1)	{
					minLen = right - left + 1;
					result = s.substring(left, right+1);
				}
				letterCount[s.charAt(left)]++;
				if (letterCount[s.charAt(left)] > 0)
					--count;
				left++;
			}
		}
		System.out.println("Minimum window substring ("+s+","+t+") = "+result);
		return result; 
	}
}