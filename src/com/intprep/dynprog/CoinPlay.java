package com.intprep.dynprog;

public class CoinPlay extends com.intprep.recursion.problems.CoinPlay 
{
	public static void main (String[] args) {
		coinPlay (new int[] {8,15,3,7});
	}
	
	protected static void coinPlay (int[] values) {
		com.intprep.recursion.problems.CoinPlay.coinPlay(values);
		int maxVal = coinPlayWithDP(values);
		System.out.println("Maximum coin play for (with dynprog) "+toString(values)+" = "+maxVal);
		System.out.println("-------------------------------------------------------------------------");
	}
	
	private static int coinPlayWithDP (int[] values)	{
		// 1. initialize
		int N = values.length;
		int[][] dpt = new int[N][N];
		// 2. pre-populate
		for (int i = 0; i < N-1; i++) { dpt[i][i] = values[i]; dpt[i][i+1] = Math.max(values[i], values[i+1]); }
		dpt[N-1][N-1] = values[N-1];
		// 3. populate
		for (int i = N-1; i >= 0; i--)	{
			for (int j = 0; j < N; j++)	{
				if (i+1 < j) {
					dpt[i][j] = Math.max(values[i] + Math.min(dpt[i+2][j], dpt[i+1][j-1]), 
										 values[j] + Math.min(dpt[i+1][j-1], dpt[i][j-2])
									);
				}
			}
		}
		// 4. return
		return Math.max(dpt[0][0], dpt[0][N-1]);
	}
}
