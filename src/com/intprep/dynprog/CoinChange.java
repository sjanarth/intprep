package com.intprep.dynprog;

import java.util.Arrays;

/*
 * Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, 
 * what is the minimum number of coins that add up to N. The ordering of the coins doesn't matter.
 * 
 * For example, 
 * 
 * N = 4 and S = {1, 2, 3}, 
 * there are four solutions: 
 * 		{1,1,1,1}, {1,1,2}, {2,2}, {1,3}. 
 * So output should be 2. 
 * 
 * N = 10 and S = {2, 5, 3, 6}, 
 * there are five solutions: 
 * 		{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 * So the output should be 2.
 */

public class CoinChange extends com.intprep.recursion.problems.CoinChange
{
	public static void main (String[] args) {
		findMinCoinChange (8, new int[] {2,3,5});
		findMinCoinChange (20, new int[] {2,3,5,7});
	}
	
	protected static void findMinCoinChange (int sum, int[] coins) {
		com.intprep.recursion.problems.CoinChange.findMinCoinChange(sum, coins);
		int min = findMinCoinChangeUsingDP (sum, coins);
		System.out.println("Minimum coin change to make (using dynprog) "+sum+
				" from "+toString(coins)+
				" is "+min
				);
		System.out.println("------------------------------------------------------------------");
	}
	
	private static int findMinCoinChangeUsingDP (int sum, int[] coins) {
		// 0. check for edge cases
		for (int c : coins) if (c == sum) return 1;
		// 1. initialize
		int[] dpt = new int[sum+1];
		for (int i = 0; i <= sum; i++) dpt[i] = Integer.MAX_VALUE;
		// 2. pre-populate
		dpt[0] = 0;
		// 3. populate
		for (int i = 1; i <= sum; i++)	{
			for (int c : coins) {
				if (i >= c)	
					dpt[i] = Math.min(dpt[i], dpt[i-c]);
			}
			if (dpt[i] != Integer.MAX_VALUE) dpt[i]++;
		}
		// 4. return
		return dpt[sum];
	}

	private static String toString (int[] arr) {
		return Arrays.toString(arr).
					replaceAll("\\[", "\\{").
					replaceAll("\\]", "\\}").
					replaceAll(" ", "");
	}
}