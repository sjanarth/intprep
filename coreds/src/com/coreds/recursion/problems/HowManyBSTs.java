package com.coreds.recursion.problems;

import java.util.HashMap;
import java.util.Map;

public class HowManyBSTs 
{
	public static void main (String[] args)	{
		howManyBSTs(3);
		howManyBSTs(5);
		howManyBSTs(10);
	}
	
	private static void howManyBSTs(int n)	{
		long count = howManyBSTsNoMemo(n);
		System.out.println("howManyBSTs("+n+") no memo = "+count);
		long count2 = howManyBSTsWithMemo(n, new HashMap<Integer,Long>());
		System.out.println("howManyBSTs("+n+") with memo = "+count2);
	}
	
	private static long howManyBSTsNoMemo (int n)	{
		if (n == 0) return 1;
		long count = 0;
		for (int left = 0; left < n; left++)	{
			int right = n - 1 - left;
			count = count + howManyBSTsNoMemo(left) * howManyBSTsNoMemo(right);
		}
		return count;
	}
	
	private static long howManyBSTsWithMemo (int n, Map<Integer,Long> memo)	{
		if (n == 0) return 1;
		else if (memo.containsKey(n)) return memo.get(n);
		long count = 0;
		for (int left = 0; left < n; left++)	{
			int right = n - 1 - left;
			count = count + howManyBSTsWithMemo(left, memo) * howManyBSTsWithMemo(right, memo);
		}
		memo.put(n, count);
		return count;
	}
}