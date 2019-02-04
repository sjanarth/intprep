package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 1. Compute a hash of the given pattern.
 * 2. Gather a list of substrings of the given text 
 *    whose length matches the length the pattern.
 * 3. Compute the hash of each of the substrings from #2
 * 4. Compare the hashes from #1 and #3 to find the indexes
 *    of the substrings that match the pattern.
 * 5. To guard against hash collisions, perform a full text 
 *    compare of candidate matches against the given pattern. 
 *    
 *    Time complexity:   o(n^2*m)
 *    Space complexity:  o(n^2)
 */

public class HashBasedSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		int m = pattern.length();
		Map<String,List<Integer>> subs = getAllSubstrings(text, m);
		List<Integer> matches = subs.get(pattern);
		if (matches == null)	{ 
			matches = new ArrayList<Integer>();
		} else {
			// Check for hash collisions and make sure 
			// at least for one of the matching indexes
			int index = matches.get(0);
			boolean hashCollision = false;
			for (int i = 0; i < pattern.length(); i++)	{
				if (text.charAt(index+i) != pattern.charAt(i))	{
					hashCollision = true;
					break;
				}
			}
			if (hashCollision)
				matches.clear();
		}
		return matches.toArray(new Integer[0]);
	}
	
	protected Map<String,List<Integer>> getAllSubstrings (String text, int m)	{
		Map<String,List<Integer>> subs = new HashMap<String,List<Integer>>();	
		for (int i = 0; i < text.length(); i++) {
			for (int j = 1; j <= text.length() - i; j++)	{
				if (j == m)	{
					String sub = text.substring(i, i+j);
					List<Integer> indices = subs.get(sub);
					if (indices == null) indices = new ArrayList<Integer>();
					indices.add(i);
					subs.put(sub, indices);
				}
			}
		}
		System.out.println("    Found "+subs.size()+" substrings of length "+m);
		//for (String sub : subs.keySet())
			//System.out.println(subs.get(sub)+": "+sub);
		return subs;
	}
}
