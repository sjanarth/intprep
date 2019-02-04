package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Rabin-Karp is an optimized version of the simple hash based substring searcher.
 * At the heart of Rabin-Karp lies the idea of rolling hashes which are far
 * more efficient to compute than a full on simple hash from scratch.
 * See the simpleHash and rollingHash APIs below to get a handle of this idea.
 * 
 * Time complexity:  o(n+m)
 * Space complexity: o(1)
 * 
 * References:
 * 	 https://www.youtube.com/watch?v=H4VrKHVG5qI
 */
public class RabinKarpSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		long hashPattern = simpleHash(pattern.toCharArray());
		String nextSub = text.substring(0,m);
		long hashText = simpleHash(nextSub.toCharArray());
		List<Integer> matches = new ArrayList<Integer>();
		int i = 0, j = 0;
		for (i = 0; i <= n-m; i++)	{
			//System.out.println("    i="+i+",nextSub="+nextSub+",hashText="+hashText);
			if (hashText == hashPattern)	{
				for (j = 0; j < m; j++)
					if (text.charAt(i+j) != pattern.charAt(j))
						break;
				if (j == m)
					matches.add(i);
			}
			if (i < n - m) {
				char prevChar = text.charAt(i);
				nextSub = text.substring(i+1, i+1+m);
				hashText = rollingHash (hashText, prevChar, nextSub.toCharArray());
			}
		}
		return matches.toArray(new Integer[0]);
	}
	
	private long simpleHash (char[] text) {
		long hash = 0;
		long k = 0;
		for (int i = 0; i < text.length; i++, k++)	
			hash = hash + (long) text[i] * (long) Math.pow(PRIME_FOR_HASH, k);
		return hash;
	}
	
	private long rollingHash (long prevHash, char prevChar, char[] text)	{
		long hash = prevHash - (long) prevChar;
		int last = text.length - 1;
		hash = hash / PRIME_FOR_HASH;
		hash = hash + (long) text[last] * (long) Math.pow(PRIME_FOR_HASH, last);
		return hash;
	}
	
	private static final long PRIME_FOR_HASH = 11;
}