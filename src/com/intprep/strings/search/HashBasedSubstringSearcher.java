package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
 *    Time complexity:   o(n^2*m
 *    Space complexity:  o(n^2)
 */
public class HashBasedSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		int k = pattern.length();
		int hashPattern = pattern.hashCode();
		Map<String,List<Integer>> subs = getAllSubstrings(text, k);
		List<Integer> matches = new ArrayList<Integer>();
		for (String sub : subs.keySet())	{
			if (hashPattern == sub.hashCode()) {
				int index = subs.get(sub).get(0);
				// Check for hash collisions and make sure
				boolean badHashMatch = false;
				for (int i = 0; i < pattern.length(); i++)	{
					if (text.charAt(index+i) != pattern.charAt(i))	{
						badHashMatch = true;
						break;
					}
				}
				if (!badHashMatch)
					matches.addAll(subs.get(sub));
			}
		}
		return matches.toArray(new Integer[0]);
	}
	
	protected Map<String,List<Integer>> getAllSubstrings (String text, int k)	{
		// Rabin-Karp relies on the ordering of the substrings for its rolling hash logic
		// Hence, it is critical that we preserve the ordering via a LinkedHashMap
		Map<String,List<Integer>> subs = new LinkedHashMap<String,List<Integer>>();	
		for (int i = 0; i < text.length(); i++) {
			for (int j = 1; j <= text.length() - i; j++)	{
				if (j == k)	{
					String sub = text.substring(i, i+j);
					List<Integer> indices = subs.get(sub);
					if (indices == null) indices = new ArrayList<Integer>();
					indices.add(i);
					subs.put(sub, indices);
				}
			}
		}
		System.out.println("    Found "+subs.size()+" substrings of length "+k);
		//for (String sub : subs.keySet())
			//System.out.println(subs.get(sub)+": "+sub);
		return subs;
	}
}
