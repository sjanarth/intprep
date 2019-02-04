package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

/*
 * Repeatedly call String.indexOf() to gather a list of
 * indices in the original text that have the given pattern.
 * 
 * Time complexity:  o(m*n)
 * Space complexity: o(1)
 */
public class JavaSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	public Integer[] searchSubstring(String text, String pattern) {
		List<Integer> matches = new ArrayList<Integer>();
		int index = text.indexOf(pattern);
		while (index > -1)	{
			matches.add(index);
			index = text.indexOf(pattern, index+1);
		}
		return matches.toArray(new Integer[0]);
	}
}