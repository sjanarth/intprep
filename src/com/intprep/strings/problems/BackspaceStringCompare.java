package com.intprep.strings.problems;

/*
 * Leetcode -- https://leetcode.com/explore/interview/card/google/59/array-and-strings/3060/
 * 
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * 
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * 
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * 
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * 
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * 
 * Note:
 * 
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * 
 * Follow up: Can you solve it in O(N) time and O(1) space?
 * 
 */
public class BackspaceStringCompare 
{
	public static void main(String[] args) {
		backspaceCompare("ab#c", "ad#c");
		backspaceCompare("ab##", "c#d#");
		backspaceCompare("a##c", "#a#c");
		backspaceCompare("a#c", "b");
	}
	
	public static boolean backspaceCompare(String S, String T) {
        boolean retVal = transform(S).equals(transform(T));
        System.out.println("backspaceCompare("+S+","+T+") = "+retVal);
        return retVal;
    }
	
	private static String transform(String s)	{
		char[] chars = s.toCharArray();
		char[] output = new char[chars.length];
		int ptr = 0;
		for (int i = 0; i < chars.length; i++)	{
			if (chars[i] == '#') {
				if (ptr > 0) 
					output[--ptr] = '\0';
			} else {
				output[ptr++] = chars[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < output.length; i++)
			if (output[i] == '\0') break;
			else sb.append(output[i]);
		System.out.println("transform("+s+") = "+sb.toString());
		return sb.toString();
	}
}