package com.intprep.recursion.wip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WellFormedBrackets 
{
	private static void swap (char[] chars, int i, int j)	{
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}

	private static boolean isWellFormed (String expr)	{
		if (expr.length() == 0)
			return false;
		System.out.println("isWellFormed: "+expr);
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); i++) {
			char ch = expr.charAt(i);
	//		System.out.println("   i="+i+", ch="+ch);
			if (ch == ')')	{
				if (stack.isEmpty())	{
	//				System.out.println(" : false");
					return false;
				} else {
					stack.pop();
				}	
			} else {
				stack.push('(');
			}
		}
		//System.out.println(" : "+stack.isEmpty());
		return stack.isEmpty();
	}
	
	private static void getAllWellFormedBrackets (char[] input, int i, Set<String> outList)	{
		if (i == input.length-1) {
			String expr = String.valueOf(input);
			if (isWellFormed(expr))	{
//				System.out.println("Adding "+expr+" of length="+expr.length());
				outList.add(expr);
			}
		} 
		for (int j = i; j < input.length; j++)	{
			swap (input, i, j);
			getAllWellFormedBrackets (input, i+1, outList);
			swap (input, i, j);
		}
	}
	
	private static String[] getAllWellFormedBracketsMain (int n)	{
		char[] input = new char[n*2];
		for (int i = 0; i < n*2; i++)
			input[i] = (i%2) == 0 ? '(' : ')';
		Set<String> outList = new HashSet<String>();
		getAllWellFormedBrackets (input, 0, outList);
		return outList.toArray(new String[0]);
	}
	
	public static void main (String[] args) {
		String[] outList = getAllWellFormedBracketsMain (6);
		for (String s : outList)
			System.out.println(s);
	}
}
