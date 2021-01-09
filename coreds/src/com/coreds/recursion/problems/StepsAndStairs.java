package com.coreds.recursion.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * There are n stairs, a person standing at the bottom wants to reach the top. 
 * He can climb a certain number of steps at once. For instance, the person can 
 * climb either 1 stair or 2 stairs at a time. Count the number of ways, the 
 * person can reach the top.
 * 
 * Note: Solve the problem for general case i.e. for n stairs, and different kinds 
 * of steps that can be taken (e.g. instead of only 1 or 2 steps, it could be 2, 3 and 5 steps at a time).
 */

public class StepsAndStairs 
{
	public static void main(String[] args)	{
		countStepsAndStairs(7, new int[] {2,3});
	}
	
	protected static void countStepsAndStairs(int n, int[] steps)	{
		long count = countStepsAndStairsNoMemo(n, steps);
		System.out.println("countStepsAndStairs("+n+","+toString(steps)+") No memo = "+count);
		long count2 = countStepsAndStairsWithMemo(n, steps, new HashMap<Integer,Long>());
		System.out.println("countStepsAndStairs("+n+","+toString(steps)+") With memo = "+count2);
	}
	
	private static long countStepsAndStairsNoMemo (int n, int[] steps) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		long count = 0;
		for (int s : steps) {
			count = count + countStepsAndStairsNoMemo(n-s, steps);
		}
		return count;
	}
	
	private static long countStepsAndStairsWithMemo (int n, int[] steps, Map<Integer,Long> memo) {
		if (n < 0) return 0;
		if (n == 0) return 1;
		if (memo.containsKey(n)) return memo.get(n);
		long count = 0;
		for (int s : steps) {
			count = count + countStepsAndStairsWithMemo(n-s, steps, memo);
		}
		memo.put(n, count);
		return count;
	}
	
	protected static String toString(int[] arr) {
		return Arrays.toString(arr).
				replaceAll("  ", ",").
				replaceAll("\\[", "{").
				replaceAll("\\]", "}");
	}
}
