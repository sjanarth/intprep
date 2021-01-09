package com.coreds.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class WellFormedBrackets 
{
	public static void main (String[] args) {
		findWellFormedBrackets(2);
		findWellFormedBrackets(3);
		findWellFormedBrackets(4);
	}
	
	private static void findWellFormedBrackets (int n)	{
		List<String> wellformed = new ArrayList<String>();
		findWellFormedBrackets(0, 0, n, "", wellformed);
		System.out.print(n+" => ");
		for (String wf : wellformed)
			System.out.print(wf+",");
		System.out.println();
	}
	
	private static void findWellFormedBrackets(int open, int close, int n, String s, List<String> wellformed)	{
		if (close == n)	{
			wellformed.add(s);
			return;
		}
		if (open < n)	
			findWellFormedBrackets(open+1, close, n, s+"(", wellformed);
		if (open > close)
			findWellFormedBrackets(open, close+1, n, s+")", wellformed);
	}
}
