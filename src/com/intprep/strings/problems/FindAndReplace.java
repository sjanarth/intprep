package com.intprep.strings.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/59/array-and-strings/3057/
 * 
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  
 * The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * 
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", 
 * then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * 
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", 
 * as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing 
 * because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * 
 * All these operations occur simultaneously.  
 * It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * 
 * Example 1:
 * 
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * 		"cd" starts at index 2 in S, so it's replaced by "ffff".
 * 
 * Example 2:
 * 
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
 * 		"ec" doesn't starts at index 2 in the original S, so we do nothing.
 * 
 * Notes:
 * 
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 */
public class FindAndReplace 
{
	public static void main(String[] args) {
		findReplaceString("abcd", new int[] {0,2}, new String[] {"a", "cd"}, new String[] {"eee", "ffff"});
		findReplaceString("abcd", new int[] {0,2}, new String[] {"ab", "ec"}, new String[] {"eee", "ffff"});
	}
	
	public static String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
		System.out.print("findReplace "+s+", "+Arrays.toString(indexes)+", "+Arrays.toString(sources)+", "+Arrays.toString(targets)+" = ");
		Map<Integer,String> map1 = new TreeMap<>();
		Map<Integer,Integer> map2 = new TreeMap<>(); 
		for (int i = 0; i < indexes.length; i++)	{
			int ind = s.indexOf(sources[i], indexes[i]);
			if (ind == indexes[i])	{
				map1.put(indexes[i], targets[i]);
				map2.put(indexes[i], sources[i].length());
			}
		}
		StringBuilder sb = new StringBuilder();
		int start = 0;
		for (Integer k : map1.keySet()) {
			if (start == k)	{
				sb.append(map1.get(k));
				start = start + map2.get(k);
			} else {
				while (start < k)	{
					sb.append(s.charAt(start++));
				}
				sb.append(map1.get(k));
				start = start + map2.get(k);
			}
		}
		if (start < s.length()) {
			sb.append(s.substring(start));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}