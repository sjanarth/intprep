package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * https://www.youtube.com/watch?v=H4VrKHVG5qI
 */
public class RabinKarpSubstringSearcher extends HashBasedSubstringSearcher 
{
	/*
	 * Rabin-Karp is an optimized version of the simple hash based substring searcher.
	 * At the heart of Rabin-Karp lies the idea of rolling hashes which are far
	 * more efficient to compute than a full on simple hash from scratch.
	 * See the simpleHash and rollingHash APIs below to get a handle of this idea.
	 * 
	 */
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		int k = pattern.length();
		// Gather all substrings of length = lengthOf(pattern) in "sliding" order of text
		Map<String,Integer> subs = getAllSubstrings(text, k);
		List<Integer> matches = new ArrayList<Integer>();
		double hashPattern = simpleHash(pattern.toCharArray());
		System.out.println("    hashPattern: "+hashPattern);
		Iterator<String> it = subs.keySet().iterator();
		String currSub = it.next();
		double currHash = simpleHash(currSub.toCharArray());
		//System.out.println("    currSub="+currSub+", currHash="+currHash);
		if (currHash == hashPattern)	
			matches.add(subs.get(currSub));
		while (it.hasNext())	{
			String nextSub = it.next();
			currHash = rollingHash (currHash, currSub.charAt(0), nextSub.toCharArray());
			//System.out.println("    nextSub="+nextSub+", currHash="+currHash);
			if (currHash == hashPattern)
				matches.add(subs.get(nextSub));
			currSub = nextSub;
		}
		return matches.toArray(new Integer[0]);
	}
	
	private double simpleHash (char[] text) {
		double hash = 0;
		double k = 0;
		for (int i = 0; i < text.length; i++, k++)	
			hash = hash + (double) text[i] * Math.pow(PRIME_FOR_HASH, k);
		return hash;
	}
	
	private double rollingHash (double prevHash, char prevChar, char[] text)	{
		double hash = prevHash - (double) prevChar;
		int last = text.length - 1;
		hash = hash / PRIME_FOR_HASH;
		hash = hash + (double) text[last] * Math.pow(PRIME_FOR_HASH, last);
		return hash;
	}
	
	private static final double PRIME_FOR_HASH = 11;
}