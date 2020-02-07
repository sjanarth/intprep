package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class CountIslands 
{
	public static void main (String[] args) {
		countIslands (buildGrid2());
	}
	
	private static int[][] buildGrid2()	{
		int[][] grid = new int[1][2];
		grid[0][0] = 1;
		grid[0][1] = 1;
		return grid;
	}
	
	private static int[][] buildGrid()	{
		int[][] grid = new int [5][5];
		for (int i = 0; i < grid.length; i++)	{ 
			for (int j = 0; j < grid[i].length; j++)
				grid[i][j] = 0;
		}
		grid[0][1] = 1;
		grid[0][4] = 1;
		grid[1][1] = 1;
		grid[1][2] = 1;
		grid[2][3] = 1;
		grid[2][4] = 1;
		grid[3][1] = 1;
		grid[3][2] = 1;
		grid[4][4] = 1;
		return grid;
	}
	
	private static int countIslands (int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					processIsland (grid, i, j);
					count++;
				}
			}
		}
		System.out.println("Number of islands = "+count);
		return count;
	}
	
	private static void processIsland (int[][] grid, int i, int j) {
		if (grid[i][j] == 0)
			return;
		grid[i][j] = 0;
		for (String coord : getNeighbors (grid, i, j))	{
			int n_i = Integer.parseInt(coord.split(",")[0]);
			int n_j = Integer.parseInt(coord.split(",")[1]);
			if (grid[n_i][n_j] == 1)
				processIsland (grid, n_i, n_j);
		}
	}
	
	private static List<String> getNeighbors (int[][] grid, int i, int j)	{
		List<String> neighbors = new ArrayList<String>();
		if ((i-1) >= 0) neighbors.add(String.valueOf((i-1)+","+j));
		if ((i+1) < grid.length) neighbors.add(String.valueOf((i+1)+","+j));
		if ((j-1) >= 0) neighbors.add(String.valueOf((i)+","+(j-1)));
		if ((j+1) < grid[i].length) neighbors.add(String.valueOf((i)+","+(j+1)));
		return neighbors;
	}
}