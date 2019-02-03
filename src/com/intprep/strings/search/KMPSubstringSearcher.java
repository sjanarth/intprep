package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.ics.uci.edu/~eppstein/161/960227.html
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ&list=PLrmLmBdmIlpvxhscYQdvfFNWU_pdkG5de&index=4
 */
public class KMPSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		int[] prefixes = findPrefixes (patternChars);
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
	 * For each substring in patternChars finds 
	 * 		1. If there is a suffix of the substring that is also its prefix
	 * 		2. If found, stores the index+length of the prefix into an array
	 */
	private int[] findPrefixes (char[] patternChars)	{
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
		System.out.print ("    findPrefixes: { ");
		for (int i = 0; i < prefixes.length; i++) 
			System.out.print(prefixes[i]+" ");
		System.out.println("}");;
		return prefixes;
	}
}
