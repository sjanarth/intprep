package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Suffix array (or its counterpart the suffix tree) based pattern matching
 * differs from other pattern matching algorithms in that it pre-processes
 * the text instead of the pattern. There are linear time algorithms to build
 * the suffix tree/array of the text and once available, any searches on it
 * can be performed in o(n) time, i.e, the length of the pattern to be matched.
 * 
 * Time complexity:  o(m) fixed cost + o(n) search cost
 * Space complexity: 
 * 
 * References:
 * 	 https://www.geeksforgeeks.org/pattern-searching-using-suffix-tree/
 * 	 https://www.geeksforgeeks.org/suffix-array-set-1-introduction/
 */

public class SuffixArraySubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		long start = System.nanoTime() / 1000;
		Suffix[] suffixes = buildSuffixArray (text);
		long end = System.nanoTime() / 1000;
		System.out.println("    Runtime to build suffix array: "+(end-start)+" us");
		List<Integer> matches = new ArrayList<Integer>();
		int left = 0, right = suffixes.length - 1, n = pattern.length();
		while (left < right)	{
			int mid = left + (right - left) / 2;
			int len = n > suffixes[mid].suffix.length() ? suffixes[mid].suffix.length() : n; 
			String sub = suffixes[mid].suffix.substring(0, len);
			int comp = sub.compareTo(pattern); 
			//System.out.println("    left="+left+",mid="+mid+",right="+right+",sub="+sub+",comp="+comp);
			if (comp > 0) {
				right = mid - 1;
			} else if (comp < 0) {
				left = mid + 1;
			} else {
				matches.add(suffixes[mid].position);
				while (mid >= 0 && comp == 0) {
					mid--;
					sub = suffixes[mid].suffix.substring(0, n);
					comp = sub.compareTo(pattern);
					if (comp == 0)	{
						matches.add(suffixes[mid].position);
					}
				}
				break;
			}
		}
		Collections.sort(matches);
		return matches.toArray(new Integer[0]);
	}
	
	private static class Suffix  
	{
		public Suffix (String s, int pos) { suffix = s; position = pos; }
		public String toString() { return "{"+suffix+","+position+"}"; }
		public static Comparator<Suffix> getComparator () { return comp; }
		private String suffix = null;
		private Integer position = -1;
		private static Comparator<Suffix> comp = 
				new java.util.Comparator<Suffix> () {
							@Override
							public int compare(Suffix o1, Suffix o2) {
								return o1.suffix.compareTo(o2.suffix);
							}
						};
	}
	
	private Suffix[] buildSuffixArray (String text) {
		Suffix[] suffixes = new Suffix[text.length()];
		for (int i = 0; i < text.length(); i++)	
			suffixes[i] = new Suffix(text.substring(i), i);
		Arrays.sort(suffixes, Suffix.getComparator());
		//for (int i = 0; i < suffixes.length; i++)	
			//System.out.println("    "+i+": "+suffixes[i].toString());
		return suffixes;
	}
}