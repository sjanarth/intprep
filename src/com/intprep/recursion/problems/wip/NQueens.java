package com.intprep.recursion.problems.wip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens 
{
	private static void clearGrid (char[][] grid) {
		for (int i = 0; i < grid.length; i++)
			Arrays.fill(grid[i], '-');
	}
	
	private static char[][] initGrid (int size)	{
		char[][] grid = new char[size][size];
		clearGrid (grid);
		return grid;
	}
	
	private static void printGrid (char[][] grid) {
		for (int row = 0; row < grid.length; row++)	{
			for (int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col]);
			}
			System.out.println();
		}
	}
	
	private static void saveGrid (char[][] grid, List<String[]> savedGrids)	{
		String[] sGrid = new String[grid.length];
		for (int i = 0; i < grid.length; i++)	{
			sGrid[i] = String.valueOf(grid[i]);
			System.out.println(sGrid[i]);
		}
		savedGrids.add(sGrid);	
	}
	
	private static boolean isSafe (char[][] grid, int row, int col) {
		int curRow = row, curCol = col;
		// top-left to bottom-right diagonal
		while (curRow >= 0 && curCol >= 0)	{
			if (grid[curRow--][curCol--] == 'q')
				return false;
		}
		// top-right to bottom-left diagonal
		curRow = row; curCol = col;
		while (curRow >= 0 && curCol < grid.length)	{
			if (grid[curRow--][curCol++] == 'q')
				return false;
		}
		// current column
		curRow = row; curCol = col;
		while (curRow >= 0)	{
			if (grid[curRow--][curCol] == 'q')
				return false;
		}
		return true;
	}
	
	private static boolean isComplete (char[][] grid)	{
		int count = 0;
		for (int row = 0; row < grid.length; row++)	{
			for (int col = 0; col < grid[0].length; col++)	{
				if (grid[row][col] == 'q')	{
					count++;
				}
				if (count == grid.length)
					return true;
			}
		}
		return false;
	}
	
	private static void placeQueens (char[][] grid, int row, List<String[]> savedGrids) {
		//System.out.println("placeQueens, row="+row);
		if (row == grid.length)	{
			if (isComplete(grid))	{
				// printGrid(grid);
				saveGrid (grid, savedGrids);
				System.out.println();
				clearGrid (grid);
			}
			return;
		}
		for (int col = 0; col < grid.length; col++)	{
			if (isSafe(grid, row, col))	{
				grid[row][col] = 'q';
				placeQueens (grid, row+1, savedGrids);
				grid[row][col] = '-';
			}
		}
	}
	
	private static String[][] placeQueensMain (char[][] grid)	{
		List<String[]> savedGrids = new ArrayList<String[]>();
		placeQueens (grid, 0, savedGrids);
		String[][] output = new String[savedGrids.size()][grid.length];
		for (int i = 0; i < savedGrids.size(); i++) {
			String[] validGrid = savedGrids.get(i);
			for (int j = 0; j < validGrid.length; j++)	{
				output[i][j] = validGrid[j];
			}
		}
		return output;
	}
	
	public static void main (String[] args) {
		char[][] grid = initGrid (5);
		String[][] validGrids = placeQueensMain (grid);
	}
}
