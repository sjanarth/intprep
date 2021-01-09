package com.coreds.strings.problems;

/*
 * Given a string word of length n, generate all possible numeronyms.
 * A numeronym is a word where a number is used to form an abbreviation.
 * For a given string word, a numeronym is a string with few or more 
 * contiguous letters between the first letter and last letter of word 
 * replaced with a number representing the count of letters omitted. 
 * Only one set of contiguous letters are replaced by a number.
 * 
 * e.g. “L10n” is called a numeronym of the word “Localization”, 
 * where 10 stands for the count of letters between the first letter 'L' and the last letter 'n' in the word.
 * 
 * Input Format:
 * 		Only one argument denoting input string word.
 * Output Format:
 * 		Return strings array containing all possible numeronyms of given string word.
 * 		For words = "aaaaa", arrays 
 * 			["a2aa", "aa2a", "a3a"], ["a3a", "aa2a", "a2aa"] etc will be considered as valid answer.
 * 		In case of no possible numeronym string, return empty list.
 * Constraints:
 * 		String will be composed of characters [a-z], [A-Z], [0-9] only.
 * 		1 <= n <= 120 where n is length of given string word.
 */

public class GenerateNumeronyms 
{
	public static void main(String[] args) {
		generateNumeronyms ("aabaaa");
	}

	private static void generateNumeronyms(String input) {
		int N = input.length();
		for (int len = 2; len <= N-2; len++) {
			for (int i = 1; i <= N-len-1; i++)	{
				StringBuilder sb = new StringBuilder(input.substring(0, i));
				sb.append(String.valueOf(len));
				sb.append(input.substring(i+len, N));
				System.out.print("{"+sb.toString()+"} ");
			}
			System.out.println();
		}
	}
}