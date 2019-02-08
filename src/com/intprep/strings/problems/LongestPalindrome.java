package com.intprep.strings.problems;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.intprep.strings.core.BasicSuffixArray;
import com.intprep.strings.core.GeneralizedSuffixTree;

public class LongestPalindrome 
{
	public static void main (String[] args) {
		findLP("abaabaabaaccc");
	}

	private static void findLP (String s) {
		String rev = new StringBuilder(s).reverse().toString();
		System.out.println("showLongestPalindrome("+s+") using SA = "+findLCSUsingSA(s, rev));
		System.out.println("showLongestPalindrome("+s+") using GST = "+findLCSUsingGST(new String[] {s, rev}));
	}
	
	private static String findLCSUsingSA (String s1, String s2) {
		String lcs = "";
		BasicSuffixArray sa = new BasicSuffixArray(s1 + DELIM + s2);
		//System.out.println(sa.toString());
		int[] lcp = sa.getLCPArray();
		Map<Integer,Integer> lcpMap = new TreeMap<Integer,Integer>(Collections.reverseOrder());
		for (int i = 0; i < lcp.length; i++)
			lcpMap.put(lcp[i], i);
		Iterator<Integer> it = lcpMap.keySet().iterator();
		while (it.hasNext())	{
			Integer lcp2 = it.next();
			Integer lcp2Pos = lcpMap.get(lcp2);
			//System.out.println("lcp2="+lcp2+",lcp2Pos="+lcp2Pos+",suff1="+sa.getSuffix(lcp2Pos-1)+",suff2="+sa.getSuffix(lcp2Pos));
			if (areFromDifferentSources (sa.getSuffix(lcp2Pos-1), sa.getSuffix(lcp2Pos)))	{
				lcs = sa.getSuffix(lcp2Pos).substring(0,lcp2);
				break;
			}
		}
		return lcs;
	}
	
	private static boolean areFromDifferentSources (String s1, String s2)	{
		return ((s1.contains(DELIM) && !s2.contains(DELIM)) ||
				(!s1.contains(DELIM) && s2.contains(DELIM)));
	}
	
	private static String findLCSUsingGST (String[] words) {
		return GeneralizedSuffixTree.getLCS(words);
	}
	
	
	private static final String DELIM = "$";
}
