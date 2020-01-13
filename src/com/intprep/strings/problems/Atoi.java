package com.intprep.strings.problems;

/*
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary 
 * until the first non-whitespace character is found. Then, starting from 
 * this character, takes an optional initial plus or minus sign followed by 
 * as many numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace 
 * characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers 
 * within the 32-bit signed integer range: [−231,  231 − 1]. 
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * 
 * Examples:
 * 
 * Input: "42"
 * Output: 42
 * 
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * 
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * 
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical 
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * 
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer. Therefore INT_MIN (−231) is returned.                          
 */

public class Atoi 
{
	public static void main(String[] args) {
		atoi("42");
		atoi("          -42");
		atoi("4193 with words");
		atoi("words and 987");
		atoi("-91283472332");
	}
	
	private static int atoi(String s)	{
		String input = s;
		if (input == null) return 0;
		input = input.trim();
		if (input.length() == 0) return 0;
		boolean negative = false;
		int start = -1, end = 0, size = 1;
		while (end < input.length())	{
			char ch = input.charAt(end);
			int n = ch - '0';
			if (ch == '+')	{
				if (start == -1) start = end+1;
				else break;
			} else if (ch == '-')	{
				if (start == -1) start = end+1;
				else break;
				negative = true;
			} else if (n >= 0 && n <= 9)	{
				if (start == -1) start = end;
				size = size * 10;	
			} else if (start > -1) {
				break;
			}
			end++;
		}
		size = size / 10;
		input = input.substring(start, end);
		System.out.println("atoi("+s+")");
		System.out.println("    input="+input);
		long sum = 0; int i = 0;
		while (i < input.length()) {
			sum = sum + size * (input.charAt(i) - '0');
			i++;
			size = size / 10;
			if (sum > Integer.MAX_VALUE)	{
				sum = Integer.MAX_VALUE;
				break;
			}
		}
		if (negative) sum = sum * -1;
		System.out.println("    sum="+sum);
		return 0;
	}
}
