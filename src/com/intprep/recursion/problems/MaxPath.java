package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a matrix of N * M. Find the maximum path sum in matrix. 
 * The maximum path is sum of all elements from (0,0) to (N,M) 
 * where you are allowed to move only down or horizontally to the right.
 */

public class MaxPath 
{
	public static void main (String[] args) {
		findMaxPath (buildSampleGrid(5, 5));
	}
	
	protected static int[][] buildSampleGrid(int n, int m)	{
		System.out.println("Sample Grid");
		int[][] grid = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				grid[i][j] = getRandomValue();
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		return grid;
	}
	
	private static int getRandomValue () {
		final int MIN_VALUE = 10;
		final int MAX_VALUE = 99;
		int value = (int) (Math.random() * (MAX_VALUE - MIN_VALUE));
		return MIN_VALUE+value;
	}
	
	protected static void findMaxPath (int[][] grid) {
		int max = findMaxPathNoMemo (grid, 0, 0);
		System.out.println("Max-path = "+max);

		int max2 = findMaxPathWithMemo (grid, 0, 0, new HashMap<String,Integer>());
		System.out.println("Max-path with memo = "+max2);
	}
	
	private static int findMaxPathNoMemo (int[][] grid, int r, int c)	{
		if (r == grid.length || c == grid[0].length)
			return 0;
		else
			return grid[r][c] + 
						Math.max(findMaxPathNoMemo (grid, r+1, c), 
								 findMaxPathNoMemo (grid, r, c+1));
	}

	private static int findMaxPathWithMemo (int[][] grid, int r, int c, Map<String,Integer> memo)	{
		String key = makeKey (r, c);
		if (memo.containsKey(key)) return memo.get(key);
		int max = 0;
		if (r == grid.length || c == grid[0].length)	{	
			max = 0;
		} else	{
			max = grid[r][c] + 
						Math.max(findMaxPathNoMemo (grid, r+1, c), 
								 findMaxPathNoMemo (grid, r, c+1));
		}
		memo.put(key, max);
		return max;
	}
	
	private static String makeKey (int r, int c)	{
		StringBuilder sb = new StringBuilder();
		sb.append(r); sb.append(","); sb.append(c);
		return sb.toString();
	}
}