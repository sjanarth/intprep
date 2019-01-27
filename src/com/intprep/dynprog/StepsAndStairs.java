package com.intprep.dynprog;

import java.util.HashMap;

/*
 * There are n stairs, a person standing at the bottom wants to reach the top. 
 * He can climb a certain number of steps at once. For instance, the person can 
 * climb either 1 stair or 2 stairs at a time. Count the number of ways, the 
 * person can reach the top.
 * 
 * Note: Solve the problem for general case i.e. for n stairs, and different kinds 
 * of steps that can be taken (e.g. instead of only 1 or 2 steps, it could be 2, 3 and 5 steps at a time).
 */

public class StepsAndStairs extends com.intprep.recursion.problems.StepsAndStairs 
{
	public static void main(String[] args)	{
		countStepsAndStairs(7, new int[] {2,3});	
	}
	
	protected static void countStepsAndStairs(int n, int[] steps)	{
		com.intprep.recursion.problems.StepsAndStairs.countStepsAndStairs(n, steps);
		long count = countStepsAndStairsUsingDP (n, steps);
		System.out.println("countStepsAndStairs("+n+","+toString(steps)+") Using DP = "+count);
	}
	
	private static long countStepsAndStairsUsingDP (int n, int[] steps)	{
		// 1. Initialize
		long[] dpt = new long[n+1];
		// 2. Prepopulate
		dpt[0] = 1;
		// 3. Populate
		for (int i = 1; i <= n; i++) {
			for (int s : steps) {
				if (i-s >= 0)
					dpt[i] = dpt[i] + dpt[i-s];
			}
		}
		// 4. Return
		return dpt[n];
	}
}
