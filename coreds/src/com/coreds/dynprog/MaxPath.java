package com.coreds.dynprog;

/*
 * Given a matrix of N * M. Find the maximum path sum in matrix. 
 * The maximum path is sum of all elements from (0,0) to (N,M) 
 * where you are allowed to move only down or horizontally to the right.
 */
public class MaxPath extends com.coreds.recursion.problems.MaxPath
{
	public static void main (String[] args) {
		findMaxPath (buildSampleGrid(5, 5));
	}
	
	protected static void findMaxPath (int[][] grid) {
		com.coreds.recursion.problems.MaxPath.findMaxPath(grid);
		int max = findMaxPathUsingDP (grid);
		System.out.println("Max-path using dynprog = "+max);
	}
	
	private static int findMaxPathUsingDP (int[][] grid) {
		int N = grid.length;
		int M = grid[0].length;
		// 1. initialize
		int[][] dpt = new int[N+1][M+1];
		// 2. pre-populate
		for (int c = 0; c <= M; c++) dpt[N][c] = 0;
		for (int r = 0; r <= N; r++) dpt[r][M] = 0;
		// 3. populate
		for (int r = N-1; r >= 0; r--)
			for (int c = M-1; c >= 0; c--)
				dpt[r][c] = grid[r][c] + Math.max(dpt[r][c+1], dpt[r+1][c]);
		// 4. return
		return dpt[0][0];
	}
}