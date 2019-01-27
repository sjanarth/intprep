package com.intprep.recursion.wip;

import java.util.ArrayList;
import java.util.List;

public class ExpressionsToATarget
{
	public static void main (String[] args) {
		findExpressions("222", 24);
	}
	
	private static void findExpressions (String s, int target)	{
		System.out.println("Inputs: s="+s+", target="+target);
		System.out.println("Output:");
		List<String> exprs = new ArrayList<String>(); 
		findExpressions (s, target, 1, exprs);
		for (String exp : exprs)	{
			System.out.println(exp);
		}
	}
	
	private static void findExpressions (String s, int target, int k, List<String> output) {
		for (int i = k; i < s.length(); i++) {
		}
	}
}