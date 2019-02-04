package com.intprep.strings.search;

import java.util.ArrayList;
import java.util.List;

/*
 * A basic implementation of the Z pattern matching algorithm.
 * 
 * 1. Pre-processes the pattern to find the longest substring
 *    starting at each index that is also a prefix of the pattern
 *    
 * 2. Iterates through the "Z-values" from #1 and whenever a z-value
 *    matches the length of the pattern, that indicates a matching index.
 *    
 *    Time complexity:  o(m+n)
 *    Space complexity: o(n)
 * 
 * References:
 *   https://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
 * 	 https://www.youtube.com/watch?v=CpZh4eF8QBw&index=1&list=PLrmLmBdmIlpvxhscYQdvfFNWU_pdkG5de
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
	 * For each index of patternChars finds the 
	 * longest substring starting at that index 
	 * which is also a prefix of patternChars.
	 * 
	 * Z(k) = longest substring starting at k which 
	 *        is also a prefix of the string
	 * 
	 * Example-1:
	 * 	 index          0 1 2 3 4 5 6 7 
	 *   patternChars = a b c d a b c y
	 *   Returns      = X 0 0 0 3 0 0 0
	 * 
	 * Example-2:
	 * 	 index          0 1 2 3 4 5 6 7 8  
	 *   patternChars = a b c d a b c d y
	 *   Returns      = X 0 0 0 4 0 0 0 0 
	 * 
	 * Example-3:
	 * 	 index          0 1 2 3 4 5 6 7 8
	 *   patternChars = a b c d a c d y c
	 *   Returns      = X 0 0 0 1 0 0 0 0 
	 * 
	 */
	private int[] findZValues (char[] patternChars)	{
		int[] zValues = new int[patternChars.length];
		zValues[0] = 0 ;
		int n = patternChars.length; 
        // [L,R] make a window which matches with prefix of s 
        int left = 0, right = 0; 
        for(int i = 1; i < n; ++i) { 
            // if i>R nothing matches so we will calculate. 
            // Z[i] using naive way. 
            if(i > right){ 
	            left = right = i; 
	            while(right < n && patternChars[right - left] == patternChars[right]) 
	                right++; 
	            zValues[i] = right - left; 
	            right--; 
            } else	{ 
                int k = i - left; 
                if(zValues[k] < right - i + 1) { 
                    zValues[i] = zValues[k]; 
                } else{ 
                	left = i; 
					while(right < n && patternChars[right - left] == patternChars[right]) 
					    right++; 
					  
					zValues[i] = right - left; 
					right--; 
                } 
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
	
	public static void main (String[] args)	{
		ZSubstringSearcher searcher = new ZSubstringSearcher();
		searcher.findZValues("abcdabcy".toCharArray());
		searcher.findZValues("abcdabcdy".toCharArray());
		searcher.findZValues("abcdacdyc".toCharArray());
	}
	
}