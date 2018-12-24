package com.intprep.dynprog;

import java.util.Stack;

public class MaxPath 
{
	private static int[][] buildSampleGrid(int n, int m)	{
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
		int value = (int) (Math.random() * (MAX_VALUE - MIN_VALUE));
		return MIN_VALUE+value;
	}
	
	public static void main (String[] args) {
		int[][] grid = buildSampleGrid(5, 5);
		findMaxPathRecursive(grid);
		findMaxPathDP(grid);
	}
	
	private static void findMaxPathRecursive (int[][] grid) {
		int maxVal = findMaxPathRecursive(grid, 0, 0);
		System.out.println("Max-path recursive = "+maxVal);
	}
	
	private static int findMaxPathRecursive (int[][] grid, int r, int c)	{
		if (r == grid.length || c == grid[0].length)
			return 0;
		else
			return grid[r][c] + Math.max(findMaxPathRecursive (grid, r+1, c), 
											findMaxPathRecursive (grid, r, c+1));
	}
	
	private static void findMaxPathDP (int[][] grid) {
		int[][] dptab = new int[grid.length+1][grid[0].length+1];
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				dptab[i][j] = 0;
		for (int i = grid.length-1; i >= 0; i--)
			for (int j = grid[0].length-1; j >= 0; j--)
				dptab[i][j] = grid[i][j] + Math.max(dptab[i][j+1], dptab[i+1][j]);
		System.out.println("Max-path dynamic prog = "+dptab[0][0]);
	}
	
	private static final int MIN_VALUE = 10;
	private static final int MAX_VALUE = 99;
}