package com.coreds.recursion.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

public class CoinChange 
{
	public static void main (String[] args) {
		findMinCoinChange (8, new int[] {2,3,5});
		findMinCoinChange (20, new int[] {2,3,5,7});
	}
	
	protected static void findMinCoinChange (int sum, int[] coins) {
		int min = findMinCoinChangeNoMemo (sum, coins);
		System.out.println("Minimum coin change to make "+sum+
				" from "+toString(coins)+
				" is "+min
				);
		int min2 = findMinCoinChangeWithMemo (sum, coins, new HashMap<Integer,Integer>());
		System.out.println("Minimum coin change to make (using memo) "+sum+
				" from "+toString(coins)+
				" is "+min2
				);
	}
	
	private static int findMinCoinChangeNoMemo (int sum, int[] coins) { 	
		if (sum == 0) return 0;
		int min = Integer.MAX_VALUE;
		for (int c : coins) {
			if (c <= sum)	{
				int thisMin = findMinCoinChangeNoMemo (sum-c, coins);
				if (thisMin != Integer.MAX_VALUE && thisMin+1 < min)
					min = thisMin + 1;
			}
		}
		return min;
	}

	private static int findMinCoinChangeNoMemo2 (int sum, int[] coins) { 	
		if (sum == 0) return 0;
		if (sum < 0) return Integer.MAX_VALUE;
		for (int c : coins) if (c == sum) return 1; 
		int min = Integer.MAX_VALUE;
		for (int c : coins) {
			int thisMin = findMinCoinChangeNoMemo (sum-c, coins);
			min = Math.min(min,  thisMin <= 0 ? Integer.MAX_VALUE : thisMin);	
			if (thisMin <= 0) thisMin = Integer.MAX_VALUE;
		}
		min++;
		return min;
	}
	
	private static int findMinCoinChangeWithMemo (int sum, int[] coins, Map<Integer,Integer> memo) { 	
		if (memo.containsKey(sum)) return memo.get(sum);
		int min = findMinCoinChangeNoMemo(sum, coins);
		memo.put(sum, min);
		return min;
	}
	
	private static String toString (int[] arr) {
		return Arrays.toString(arr).
					replaceAll("\\[", "\\{").
					replaceAll("\\]", "\\}").
					replaceAll(" ", "");
	}
}