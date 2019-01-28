package com.intprep.dynprog;

/*
 * Given a rope with length n, find the maximum value maxProduct, 
 * that can be achieved for product len[0] * len[1] * ... * len[m - 1], 
 * where len[] is the array of lengths obtained by cutting the given rope into m parts.
 * The rope must be cut at least once.
 */

public class RopeCut 
{
	public static void main (String[] args) {
		for (int i = 5; i < 10; i++)
			cutRope(i);
	}
	
	private static void cutRope(int len) {
		// 1. Initialize
		int[] dpt = new int[len+1];
		// 2. Prepopulate
		if (len > 1) dpt[2] = 1;
		if (len > 2) dpt[3] = 2;
		if (len > 3) dpt[4] = 4;
		// 3. Populate
		for (int i = 5; i <= len; i++)	{
			dpt[i] = Math.max(i-3, dpt[i-3]) * 3;
		}
		// 4. Return
		System.out.println("cutRope("+len+") = "+dpt[len]);			
	}
}
