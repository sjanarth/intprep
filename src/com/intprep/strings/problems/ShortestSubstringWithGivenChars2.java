package com.intprep.strings.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestSubstringWithGivenChars2 
{
	public static void main (String[] args) {
		//showShortestSubstring("helloworld", "lwr");
		showShortestSubstring("ADOBECODEBANC","ABC");
	}

	private static String showShortestSubstring (String s, String t) {
		char[] chars = t.toCharArray();
		List<String> validSubstrings = new ArrayList<String>();
		Map<Character, Integer> indexes = new HashMap<Character,Integer>();
		int left = -1, right = 0;
		while (right < s.length()) {
			char ch = s.charAt(right);
			if (isMatchingChar(chars, ch))	{
				if (left == -1)
					left = right;
				if (indexes.size() < chars.length) {
					indexes.put(ch, right);
				} 
				System.out.print("left="+left+", right="+right); showMap(indexes);
				if (indexes.size() == chars.length) {
					String sub = s.substring(getMin(indexes), getMax(indexes)+1);
					System.out.println("Adding valid sub "+sub);
					validSubstrings.add(sub);
					indexes.remove(getMinKey(indexes));
					left = getMin(indexes);
				}
			}
			right++;
		}
		String shortestSubstring = "";
		if (validSubstrings.size() == 0)	{
			shortestSubstring = "[No matching substrings found]";
		} else {
			for (String s2 : validSubstrings)
				if (shortestSubstring.length() == 0 || shortestSubstring.length() > s2.length())
					shortestSubstring = s2;
		}
		System.out.println("ShortestSubstring("+s+", "+t+") = "+shortestSubstring);
		return shortestSubstring;
	}
	
	private static boolean isMatchingChar (char[] chars, char ch)	{
		for (char c : chars)
			if (c == ch)
				return true;
		return false;
	}
	
	private static int getMin(Map<Character,Integer> map)	{
		int min = Integer.MAX_VALUE;
		for (Integer i : map.values())
			if (min > i)
				min = i;
		return min;
	}
	
	private static Character getMinKey(Map<Character,Integer> map)	{
		Character minKey = null;;
		int minValue = Integer.MAX_VALUE;
		for (Character ch : map.keySet()) {
			if (minValue > map.get(ch))	{
				minValue = map.get(ch);
				minKey = ch;
			}
		}
		System.out.println("   getMinKey returning "+minKey);
		return minKey;
	}

	private static int getMax(Map<Character,Integer> map)	{
		int max = Integer.MIN_VALUE;
		for (Integer i : map.values())
			if (max < i)
				max = i;
		return max;
	}
	
	private static void showMap (Map<Character,Integer> map) {
		for (Character ch : map.keySet())
			System.out.print(", "+ch+"="+map.get(ch));
		System.out.println();
	}
}
