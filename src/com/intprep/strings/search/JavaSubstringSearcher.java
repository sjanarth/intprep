package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

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