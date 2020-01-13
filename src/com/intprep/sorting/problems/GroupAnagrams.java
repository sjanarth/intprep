package com.intprep.sorting.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output: [["ate","eat","tea"], ["nat","tan"], ["bat"]
]
 */

public class GroupAnagrams 
{
	public static void main(String[] args) {
		print(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	
	private static List<List<String>> groupAnagrams (String[] words)	{
		Map<String,List<String>> groups = new HashMap<String,List<String>>();
		for (String w : words) {
			char[] chars = w.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			if (!groups.containsKey(key)) groups.put(key, new ArrayList<String>());
			groups.get(key).add(w);
		}
		return new ArrayList<List<String>>(groups.values());
	}
	
	private static void print(List<List<String>> groups) {
		for (List<String> group : groups)	{
			System.out.print("{");
			for (String s : group)
				System.out.print(s+" ");
			System.out.println("}");
		}
	}
}
