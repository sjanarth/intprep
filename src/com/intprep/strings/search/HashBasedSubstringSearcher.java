package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashBasedSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		int k = pattern.length();
		int hashPattern = pattern.hashCode();
		Map<String,Integer> subs = getAllSubstrings(text, k);
		List<Integer> matches = new ArrayList<Integer>();
		for (String sub : subs.keySet())	{
			if (hashPattern == sub.hashCode()) {
				int index = subs.get(sub);
				// Check for hash collisions and make sure
				boolean badHashMatch = false;
				for (int i = 0; i < pattern.length(); i++)	{
					if (text.charAt(index+i) != pattern.charAt(i))	{
						badHashMatch = true;
						break;
					}
				}
				if (!badHashMatch)
					matches.add(subs.get(sub));
			}
		}
		return matches.toArray(new Integer[0]);
	}
	
	protected Map<String,Integer> getAllSubstrings (String text, int k)	{
		// Rabin-Karp relies on the ordering of the substrings for its rolling hash logic
		// Hence, it is critical that we preserve the ordering via a LinkedHashMap
		Map<String,Integer> subs = new LinkedHashMap<String,Integer>();	
		for (int i = 0; i < text.length(); i++) {
			for (int j = 1; j <= text.length() - i; j++)	{
				if (j == k)	{
					subs.put(text.substring(i, i+j), i);
				}
			}
		}
		System.out.println("    Found "+subs.size()+" substrings of length "+k);
		//for (String sub : subs.keySet())
			//System.out.println(subs.get(sub)+": "+sub);
		return subs;
	}
}
