package com.intprep.dynprog;

public class CountPaths2 extends com.intprep.recursion.problems.CountPaths2 
{
	public static void main (String[] args) {
		int[][] grid = buildSampleGrid(5,5);
		printGrid(grid);
		countPathsUsingDP(grid);
	}
	
	protected static void countPathsUsingDP(int[][] grid)	{
		com.intprep.recursion.problems.CountPaths2.countPaths(grid);
		int endX = grid.length, endY = grid[0].length;
		int count = countPathsUsingDP (grid, endX, endY);
		System.out.println("countPaths(0,0,"+endX+","+endY+") using dynprog = "+count);
	}
	
	private static int countPathsUsingDP (int[][] grid, int endX, int endY) {
		// 1. initialize
		int[][] dpt = new int[endY][endX]; 
		// 2. pre-populate
		dpt[endY-1][endX-1] = grid[endY-1][endX-1];
		// 3. populate
		for (int i = endY-1; i >= 0; i--)	{
			for (int j = endX-1; j >= 0; j--)	{
				if (grid[i][j] == 1)	{
					if (i < endY-1) dpt[i][j] = dpt[i][j] + dpt[i+1][j];
					if (j < endX-1) dpt[i][j] = dpt[i][j] + dpt[i][j+1];
				}
			}
		}
		// 4. return
		return dpt[0][0];
	}
}
