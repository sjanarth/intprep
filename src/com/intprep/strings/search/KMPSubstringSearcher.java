package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

/*
 * A basic implementation of the KMP pattern match algorithm.
 * 
 * 1. Pre-process the given pattern by finding every proper 
 *    prefix of the pattern and finding the length of the 
 *    longest prefix of the prefix that is also a suffix of the 
 *    prefix and notes down the length of such prefixes.
 *     
 * 2. Parses the given text and when there is a mismatch
 *    consults the prefix table to reset to the pointer in the
 *    PATTERN to an index that skips unnecessary comparisons. 
 *    
 *    Time complexity:  o(m+n)
 *    Space complexity: o(n)
 *  
 * References:
 * 	 https://www.ics.uci.edu/~eppstein/161/960227.html
 *	 https://www.youtube.com/watch?v=GTJr8OvyEVQ&list=PLrmLmBdmIlpvxhscYQdvfFNWU_pdkG5de&index=4
 */
public class KMPSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		int[] prefixes = findLPSs (patternChars);
		List<Integer> matches = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < textChars.length)	{
			if (textChars[i] == patternChars[j]) {
				i++;
				j++;
			} else if (j > 0) {
				j = prefixes[j-1];
			} else {
				i++;
			}
			if (j == patternChars.length) {
				matches.add(i - patternChars.length);
				j = 0;
			}
		}
		return matches.toArray(new Integer[0]);
	}
	
	/*
	 * For each proper prefix of patternChars finds the length of the 
	 * longest prefix of the prefix that is also a suffix of the prefix.
	 * 
	 * Returns the size of the longest prefixes for each proper prefix of patternChars.
	 * 
	 * LPS(k) = longest prefix of the substring ending at k
	 *          that is also a suffix of the substring
	 * 
	 * Example-1:
	 * 	 index          0 1 2 3 4 5 6 7 
	 *   patternChars = a b c d a b c y
	 *   Returns      = X 0 0 0 1 2 3 0
	 * 
	 * Example-2:
	 * 	 index          0 1 2 3 4 5 6 7 8  
	 *   patternChars = a b c d a b c d y
	 *   Returns      = X 0 0 0 1 2 3 4 0
	 * 
	 * Example-3:
	 * 	 index          0 1 2 3 4 5 6 7 8
	 *   patternChars = a b c d a c d y c
	 *   Returns      = X 0 0 0 1 0 0 0 0 
	 *    
	 */
	private int[] findLPSs (char[] patternChars)	{
		int[] prefixes = new int[patternChars.length];
		prefixes[0] = 0;
		for (int i = 1, j = 0; i < patternChars.length;)	{
			if (patternChars[i] == patternChars[j]) {
				prefixes[i] = j + 1;
				j++;
				i++;
			} else if (j > 0) {
				j = prefixes[j-1];
			} else {
				prefixes[i] = 0;
				i++;
			}
		}
		System.out.print ("    findLPSs: { ");
		for (int i = 0; i < prefixes.length; i++) 
			System.out.print(prefixes[i]+" ");
		System.out.println("}");
		return prefixes;
	}
	
	public static void main (String[] args)	{
		KMPSubstringSearcher searcher = new KMPSubstringSearcher();
		searcher.findLPSs("abcdabcy".toCharArray());
		searcher.findLPSs("abcdabcdy".toCharArray());
		searcher.findLPSs("abcdacdyc".toCharArray());
	}
}
