package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

public class NaiveSubstringSearcher extends AbstractSubstringSearcher 
{
	public Integer[] searchSubstring (String text, String pattern)	{
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		List<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i < textChars.length; i++) {
			int i2 = i, j = 0;
			while (j < patternChars.length) {
				if (textChars[i2] != patternChars[j])
					break;
				j++;
				i2++;
			}
			if (j == patternChars.length)	{
				matches.add(i);
				i = i + patternChars.length;
			}
		}
		return matches.toArray(new Integer[0]);
	}
}
