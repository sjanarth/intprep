package com.intprep.dynprog;

public class CoinChange 
{
	public static void main (String[] args) {
		findMinCoinChange (8, new int[] {2,3,5});
	}
	
	private static int findMinCoinChange (int sum, int[] coins) {
		if (sum == 0) return 0;
		if (sum < 0) return Integer.MAX_VALUE;
		for (int c : coins) if (c == sum) return 1; 
		int min = Integer.MAX_VALUE;
		for (int c : coins) {
			int thisMin = findMinCoinChange (sum-c, coins);
			min = Math.min (min, thisMin <= 0 ? Integer.MAX_VALUE : thisMin);
		}
		min++;
		System.out.println("Minimum coin change to make "+sum+" from "+getArray(coins)+" is "+min);
		return min;
	}
	
	private static String getArray (int[] arr) {
		StringBuilder sb = new StringBuilder ("{");
		for (int i : arr) sb.append(i+",");
		sb.append("}");
		return sb.toString();
	}
}
