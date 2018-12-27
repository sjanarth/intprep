package com.intprep.dynprog.wip;

import java.util.Arrays;

public class RopeCut 
{
	public static void main (String[] args) {
		ropeCut (new int[] {10,12,3,6,20,0}, 5);
		ropeCutDP (new int[] {10,12,3,6,20,0}, 5);
	}
	
	private static int ropeCut (int[] prices, int len) {
		if (len == 0) return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= len; i++) {
			max = Math.max(max, prices[i] + ropeCut (prices, len-i));
		}
		System.out.println("ropeCut("+toString(prices)+","+len+") = "+max);
		return max;
	}
	
	private static int ropeCutDP (int[] prices, int len) {
		int[] dpt = new int[len+1];
		dpt[0] = 0;
		for (int l = 1; l <= len; l++)	{
			int max = 0;
			for (int i = 1; i <= l; i++)	{
				max = Math.max(max,  prices[i]+dpt[l-i]);
			}
			dpt[l] = max;
		}
		System.out.println("ropeCutDP("+toString(prices)+","+len+") = "+dpt[len]);
		return dpt[len];
	}
	
	private static String toString(int[] arr)	{
		return Arrays.toString(arr).
				replaceAll("\\[", "\\{").
				replaceAll("\\]", "\\}").
				replaceAll(" ", "");
	}
}
