package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s1 and s2 and a set of operations that can performed on s1. 
 * Find minimum number of edits (operations) required to convert s1 to s2.
 * 
 * Insert
 * Remove
 * Replace
 * 
 * All of the above operations are of equal cost.
 */
public class EditDistance 
{
	public static void main (String[] args) {
		findEditDistance ("bat", "bata");	// insert
		findEditDistance ("bat", "at");		// delete
		findEditDistance ("bat", "cat");		// replace
		findEditDistance ("bat", "boil");		
		findEditDistance ("eclipse", "ellipse");
	}
	
	protected static void findEditDistance (String s1, String s2)	{
		int ed = findEditDistance (s1, s2, s1.length(), s2.length());
		System.out.println("Edit Distance ("+s1+","+s2+") = "+ed);
		int ed2 = findEditDistanceWithMemo (s1, s2, s1.length(), s2.length(), new HashMap<String,Integer>());
		System.out.println("Edit Distance With Memo ("+s1+","+s2+") = "+ed2);
	}
	
	private static int findEditDistance (String s1, String s2, int m, int n) {
		if (m == 0) return n;
		if (n == 0) return m;
		if (s1.charAt(m-1) == s2.charAt(n-1))
			return findEditDistance (s1, s2, m-1, n-1);
		return 1 + Math.min(findEditDistance (s1, s2, m-1, n-1), 
							Math.min(findEditDistance (s1, s2, m, n-1), 
									 findEditDistance (s1, s2, m-1, n)));
	}
	
	private static int findEditDistanceWithMemo (
			String s1, String s2, int m, int n, Map<String,Integer> memo) {
		String key = makeKey (m, n);
		if (memo.containsKey(key)) return memo.get(key);
		int ed = findEditDistance (s1, s2, m, n);
		memo.put(key, ed);
		return ed;
	}
	
	private static String makeKey (int m, int n)	{
		StringBuilder sb = new StringBuilder();
		sb.append(m); sb.append(","); sb.append(n);
		return sb.toString();
	}
}