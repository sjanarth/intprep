package com.intprep.strings.problems;

import java.util.Arrays;
import java.util.Set;

import com.intprep.strings.core.StringUtils;
import com.intprep.strings.core.SuffixArray;

/*
 * Given a string inputStr of length n, find the longest repeated substring in it.
 * 		- Repeated is occurring more than once. 
 * 		- It doesn't matter how many times it occurs as far as it occurs more than once.
 * 		- If there are multiple such substrings of the same size, then return any one.
 * 		- If there are no repeated substrings, then return an empty string.
 *	Example:
 *		Input: aaaa Output: aaa
 *		Input: efabcdhefhabcdiefi Output: abcd
 *	References:
 *		https://introcs.cs.princeton.edu/java/42sort/LRS.java.html
 *		http://www.garretwilson.com/blog/2011/12/15/suffix-trees-java.xhtml
 *		https://www.youtube.com/playlist?list=PLDV1Zeh2NRsCQ_Educ7GCNs3mvzpXhHW5
 */
public class LongestRepeatedSubstring 
{
	public static void main (String[] args) {
		findLRS("banana");
		findLRS("valhalla");
		findLRS("mississippi");
	}
	
	private static void findLRS (String s)	{
		SuffixArray sa = new SuffixArray(s);
		int[] LCPs = sa.getLCPArray();
		int topLCP = -1;
		int idxTopLCP = -1;
		for (int i = 0; i < LCPs.length; i++) {
			if (topLCP < LCPs[i]) {
				topLCP = LCPs[i];
				idxTopLCP = i;
			}
		}
		String lrs = sa.getSuffix(idxTopLCP).substring(0, topLCP);
		System.out.println("Longest repeated substring ("+s+") = "+lrs);
	}

	// Space complexity: o(n^2)
	private static void findLRS2 (String s) {
		// gather suffixes
		int n = s.length();
		String[] suffixes = new String[n];
		for (int i = 0; i < n; i++)
			suffixes[i] = s.substring(i, n);
		// sort them
		Arrays.sort(suffixes);
		// find lrs by comparing adjacent suffixes
		String lrs = "";
		for (int i = 0; i < n-1; i++)	{
			String x = StringUtils.lcp(suffixes[i], suffixes[i+1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		System.out.println("Longest repeated substring ("+s+") = "+lrs);
	}
}