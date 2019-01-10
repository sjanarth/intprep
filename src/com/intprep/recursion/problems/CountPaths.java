package com.intprep.recursion.problems;

/*
 * Given a M x N grid, a start and an end point, find all paths to the end point.
 * You are allowed to traverse the grid one step at a time either down or to the right.
 */

public class CountPaths
{
	public static void main (String[] args) {
		for (int i = 2; i < 10; i++)
			System.out.println("Total"+i+": "+countPaths(i, i, 0, 0));
	}

	private static int countPaths (int maxRow, int maxCol, int row, int col)	{
		if (row > maxRow-1 || col > maxCol-1)	
			return 0;
		if (row == maxRow-1 && col == maxCol-1)
			return 1;
		return countPaths (maxRow, maxCol, row+1, col) + countPaths (maxRow, maxCol, row, col+1);
	}
}