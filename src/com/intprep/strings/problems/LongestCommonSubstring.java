package com.intprep.strings.problems;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.intprep.strings.core.SuffixArray;

/*
 * References:
 * 	 https://www.youtube.com/watch?v=Ic80xQFWevc&list=PLDV1Zeh2NRsCQ_Educ7GCNs3mvzpXhHW5&index=4
 */
public class LongestCommonSubstring 
{
	public static void main (String[] args) {
		findLCS("call", "ball");
		findLCS("today", "yesterday");
		findLCS("myself", "yourself");
		findLCS("abc", "pabcu");
		findLCS("abca", "bcad");
		findLCS("daca", "bcad");
	}
	
	private static void findLCS (String s1, String s2) {
		String lcs = "";
		SuffixArray sa = new SuffixArray(s1 + DELIM + s2);
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
		System.out.println("Longest common substring("+s1+","+s2+") = "+lcs);
		//System.out.println();
	}
	
	private static boolean areFromDifferentSources (String s1, String s2)	{
		return ((s1.contains(DELIM) && !s2.contains(DELIM)) ||
				(!s1.contains(DELIM) && s2.contains(DELIM)));
	}
	
	private static final String DELIM = "$";
}
