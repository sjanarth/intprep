package com.coreds.strings.problems;

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
 */

public class MinimumWindowSubstring 
{
	public static void main (String[] args) {
		//showShortestSubstring("helloworld", "lwr");
		showShortestSubstring("ADOBECODEBANC","ABC");
		
	}

	private static void showShortestSubstring (String s1, String s2) {
		char[] inputChars = s1.toCharArray();
		char[] symbols = s2.toCharArray();
		Map<Character,Integer> lastPos = new HashMap<Character,Integer>();
		int minLen = Integer.MAX_VALUE;
		int left = -1, right = 0;
		while (right < inputChars.length) {
			for (Character symbol : symbols) {
				if (inputChars[right] == symbol) {
					if (left == -1) {
						left = right;
					}
					if (!lastPos.containsKey(symbol) || lastPos.size() < symbols.length)	{
						lastPos.put(symbol,  right);
					} else if (lastPos.size() == symbols.length) {
						int thisLen = getLength (lastPos, symbol, right);
						if (thisLen < minLen)	{
							minLen = thisLen;
							lastPos.put(symbol, right);
							left = getMin (lastPos);
						}
					}
				}
			}
			System.out.print("left="+left+", right="+right); showMap(lastPos);
			right++;
		}
		if (lastPos.size() < symbols.length) {
			System.out.println("No matching substrings found");
		} else {
			String shortSubstr =  s1.substring(getMin(lastPos), getMax(lastPos)+1);
			System.out.println("Shortest substring of ["+s1+"] containing all chars of ["+s2+"] is ["+shortSubstr+"]");
		}
	}
	
	private static int getLength (Map<Character,Integer> lastPos, char symbol, int currPos)	{
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (Character ch : lastPos.keySet()) {
			int pos = lastPos.get(ch);
			if (ch == symbol) pos = currPos;
			if (pos < min) {
				min = pos;
			} else if (pos > max) {
				max = pos;
			}
		}
		return max - min;
	}
	
	private static int getMin (Map<Character,Integer> lastPos)	{
		int min = Integer.MAX_VALUE;
		for (Character symbol : lastPos.keySet()) {
			if (lastPos.get(symbol) < min) {
				min = lastPos.get(symbol);
			}
		}
		return min;
	}
	
	private static int getMax (Map<Character,Integer> lastPos)	{
		int max = Integer.MIN_VALUE;
		for (Character symbol : lastPos.keySet()) {
			if (lastPos.get(symbol) > max) {
				max = lastPos.get(symbol);
			}
		}
		return max;
	}
	
	private static void showMap (Map<Character,Integer> map) {
		for (Character ch : map.keySet())
			System.out.print(", "+ch+"="+map.get(ch));
		System.out.println();
	}
	
	
}
