package com.intprep.dynprog;

public class CountPaths extends com.intprep.recursion.problems.CountPaths 
{
	public static void main (String[] args)	{
		for (int i = 2; i <= 10; i++)
			countPaths(0, 0, i, i);
	}

	protected static void countPaths (int startX, int startY, int endX, int endY) {
		com.intprep.recursion.problems.CountPaths.countPaths(startX, startY, endX, endY);
		int count = countPathsUsingDP (endX, endY);
		System.out.println("countPaths("+startX+","+startY+","+endX+","+endY+") using dynprog = "+count);
		System.out.println("-------------------------------------------------------------------");
	}
	
	private static int countPathsUsingDP (int endX, int endY)	{
		// 1. initialize
		int[][] dpt = new int[endX+1][endY+1];
		// 2. pre-populate
		for (int i = 0; i <= endX; i++) dpt[0][i] = 1;	// Only 1 path from any column in the last row
		for (int j = 0; j <= endY; j++) dpt[j][0] = 1;	// Only 1 path from any row in the last column
		dpt[endX][endY] = 0;	// destination cell
		// 3. populate
		for (int i = 1; i <= endY; i++)
			for (int j = 1; j <= endX; j++)
				dpt[i][j] = dpt[i-1][j] + dpt[i][j-1];
		// 4. return
		return dpt[endX][endY];
	}
}
