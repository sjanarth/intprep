package com.coreds.recursion.problems;

/*
 * Consider a maze mapped to a matrix with an upper left corner at 
 * coordinates (row, column) = (0, 0). Any movement must be in increasing 
 * row or column direction. You must determine the number of distinct 
 * paths through the maze. You will always start at position (0, 0), 
 * the top left, and end up at (max(row), max(column)), the bottom right.
 * 
 * Further, a value of '1' in any cell indicates an open cell and '0' indicates blocked. 
 * You can only travel through open cells.
 */

public class CountPaths2 
{
	public static void main (String[] args) {
		int[][] grid = buildSampleGrid(5,5);
		printGrid(grid);
		countPaths(grid);
	}
	
	protected static void countPaths(int[][] grid)	{
		int endX = grid.length-1, endY = grid[0].length-1;
		int count = countPathsNoMemo (grid, 0, 0, endX, endY);
		System.out.println("countPaths(0,0,"+endX+","+endY+") no memo = "+count);
	}
	
	private static int countPathsNoMemo (int[][] grid, int startX, int startY, int endX, int endY) {
		if (startX > endX || startY > endY)	
			return 0;
		if (startX == endX && startY == endY)
			return 1;
		int count = 0;
		if (startX+1 <= endX && grid[startX+1][startY] == 1)
			count = count + countPathsNoMemo (grid, startX+1, startY, endX, endY);
		if (startY+1 <= endY && grid[startX][startY+1] == 1)
			count = count + countPathsNoMemo (grid, startX, startY+1, endX, endY);
		return count;
	}
	
	protected static int[][] buildSampleGrid(int N, int M)	{
		int[][] grid = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				grid[i][j] = 1; //((int)(Math.random()*10)) % 2;
		return grid;
	}
	
	protected static void printGrid(int[][] grid)	{
		for (int i = 0; i < grid.length; i++)	{
			for (int j = 0; j < grid[i].length; j++)	{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
}