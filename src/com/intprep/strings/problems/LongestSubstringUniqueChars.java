package com.intprep.strings.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example:
 * 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *  
 */

public class LongestSubstringUniqueChars 
{
	public static void main (String[] args) {
		findLongestSubstrOfUniqChars ("helloworld");
		findLongestSubstrOfUniqChars ("abc");
		findLongestSubstrOfUniqChars ("abcabcbb");
		findLongestSubstrOfUniqChars ("aab");
		findLongestSubstrOfUniqChars ("pwwkew");
	}
	
	private static String findLongestSubstrOfUniqChars (String input)	{
		String result = "";
		int first = 0, second = 0;
		Map<Character,Integer> lastPos = new HashMap<>();
		while (first < input.length())	{
			char ch = input.charAt(first);
			if (lastPos.containsKey(ch)) {	
				second = Math.max(second, lastPos.get(ch) + 1);
			}
			if (result.length() < (first-second+1))	{
				result = input.substring(second, first+1);
			}
			lastPos.put(ch, first);
			first++;
		}
		System.out.println("findLongestSubstrOfUniqChars("+input+") = "+result);
		return result;
	}
}
