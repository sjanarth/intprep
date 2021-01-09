package com.coreds.strings.problems;

import java.util.Stack;

/*
 * 
 * Leetcode -- https://leetcode.com/explore/interview/card/google/59/array-and-strings/467/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * 
 * Input: "(]"
 * Output: false
 * 
 * Example 4:
 * 
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParantheses 
{
	public static void main(String[] args) {
		isValid("()");
		isValid("()[]{}");
		isValid("(]");
		isValid("([)]");
		isValid("{[]}");
		isValid("{");
		isValid("]");
	}
	
	private static boolean isValid (String s)	{
		System.out.print("isValid |"+s+"|  = ");
		boolean valid = true;
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++)	{
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{')	{ 
				stack.push(chars[i]);
			}
			else	{
				if (stack.isEmpty()) { valid = false; break; }
				char top = stack.pop();
				if (chars[i] == ')' && top != '(') { valid = false; break; }
				if (chars[i] == ']' && top != '[') { valid = false; break; }
				if (chars[i] == '}' && top != '{') { valid = false; break; }
			}
		}
		if (!stack.isEmpty()) valid = false;
		System.out.println(valid);
		return valid;
	}
}