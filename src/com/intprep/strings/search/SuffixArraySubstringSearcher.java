package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SuffixArraySubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		String[] suffixes = buildSuffixArray (text);
		List<Integer> matches = new ArrayList<Integer>();
		int left = 0, right = suffixes.length;
		/*
		while (left < right)	{
			int mid = (left + right)/2;
			int comp = suffixes[mid].compareTo(pattern);
			if (comp > 0) {
				right = mid;
			} else if (comp < 0) {
				left = mid;
			} else {
				matches.add(suffixes[mid]);
			}
		}
		*/
		return new Integer[0];
	}
	
	// Absolute naive way to build a suffix array
	private String[] buildSuffixArray (String text) {
		Set<String> suffixes = new TreeSet<String>();
		for (int i = 0; i < text.length(); i++)
			suffixes.add(text.substring(i));
		for (String s : suffixes)
			System.out.println("    suffix="+s);
		return suffixes.toArray(new String[0]);
	}
}
