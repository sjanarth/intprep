package com.intprep.strings.wip;

/*
 * Given a text string containing characters only from lowercase 
 * alphabetic characters and a pattern string containing characters 
 * only from lowercase alphabetic characters and two other special 
 * characters '.' and '*'.
 * 
 * Your task is to implement pattern matching algorithm that returns 
 * true if pattern is matched with text otherwise returns false. 
 * The matching must be exact, not partial.
 * 
 * Explanation of the special characters:
 * 		1) '.' - Matches a single character from lowercase alphabetic characters.
 * 		2) '*' - Matches zero or more preceding character. It is guaranteed that 
 * 				'*' will have one preceding character which can be any lowercase 
 * 				alphabetic character or special character '.'. But '*' will never 
 * 				be the preceding character of '*'. (That means "**" will never 
 * 				occur in the pattern string.)
 * 		'.' = "a", "b", "c", ... , "z".
 * 		a* = "a","aa","aaa","aaaa",... or empty string("").
 * 		ab* = "a", "ab", "abb", "abbb", "abbbb",...
 */

public class RegexMatcher 
{
	public static void main (String args[]) {
		System.out.println(patternMatch ("abcdefg", "a.c.*.*gg*"));
	}
	
	private static boolean patternMatch (String text, String pattern) {
		char[] textChars = text.toCharArray();
		char[] patternChars = pattern.toCharArray();
		int ti = 0, pi = 0;
		char prev_p = ' ';
		while (ti < textChars.length && pi < patternChars.length) {
			char p = patternChars[pi];
			switch (p) {
				case '.': 
					pi++;
					ti++;
					prev_p = '.';
					break;
				case '*':
					while (ti < textChars.length && (prev_p == '.' || prev_p == textChars[ti])) ti++;
					pi++;
					break;
				default:
					if (p == textChars[ti]) {
						prev_p = textChars[ti];
						ti++;
						pi++;
					} else {
						System.out.println("ti="+ti+", ["+textChars[ti]+"], pi="+pi+" ["+p+"]");
						return false;
					}
			}
		}
		return true;
	}
}