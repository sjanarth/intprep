package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.youtube.com/watch?v=CpZh4eF8QBw&index=1&list=PLrmLmBdmIlpvxhscYQdvfFNWU_pdkG5de
 */
public class ZSubstringSearcher extends AbstractSubstringSearcher 
{
	@Override
	protected Integer[] searchSubstring(String text, String pattern) {
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		char[] textChars2 = concatWithSpecialDelim (patternChars, textChars);
		int[] zValues = findZValues (textChars2);
		List<Integer> matches = new ArrayList<Integer>();
		for (int i = 0; i < zValues.length; i++)	{
			if (zValues[i] == patternChars.length)	{
				matches.add(i - patternChars.length - 1);
			}
		}
		return matches.toArray(new Integer[0]);
	}
	
	/*
	 * z(k) = longest substring starting at K which is
	 * 			also a prefix of the string
	 */
	private int[] findZValues (char[] patternChars)	{
		int[] zValues = new int[patternChars.length];
		zValues[0] = 0 ;
		// TODO: update this to reduce comparisons by reusing zValues we already know of
		for (int i = 0, j = 1; j < patternChars.length;)	{
			if (patternChars[i] == patternChars[j])	{
				int k = j;
				while (j < patternChars.length && patternChars[i] == patternChars[j]) {
					i++;
					j++;
				}
				zValues[k] = i;
				i = 0;
				j = k + 1;
			} else {
				zValues[j] = 0;
				j++;
			}
		}
		System.out.print ("    zValues: { ");
		for (int i = 0; i < zValues.length; i++) 
			System.out.print(zValues[i]+" ");
		System.out.println("}");;
		return zValues;
	}
	
	private char[] concatWithSpecialDelim (char[] patternChars, char[] textChars)	{
		char[] textChars2 = new char[patternChars.length+textChars.length+1];
		int k = 0;
		for (int i = 0; i < patternChars.length; i++, k++) 
			textChars2[k] = patternChars[i];
		textChars2[k++] = '$';	// TODO: update this to pick a char that does exists neither in text nor in pattern
		for (int i = 0; i < textChars.length; i++, k++)
			textChars2[k] = textChars[i];
		System.out.println("    concatWithDelim: "+String.valueOf(textChars2));
		return textChars2;
	}
}