package com.intprep.recursion.problems;

import java.util.Arrays;

public class NQueens 
{
	private static void clearGrid (char[][] grid) {
		for (int i = 0; i < grid.length; i++)
			Arrays.fill(grid[i], 'o');
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
	
	private static boolean isSafe (char[][] grid, int row, int col) {
		int curRow = row, curCol = col;
		// top-left to bottom-right diagonal
		while (curRow >= 0 && curCol >= 0)	{
			if (grid[curRow--][curCol--] == 'Q')
				return false;
		}
		// top-right to bottom-left diagonal
		curRow = row; curCol = col;
		while (curRow >= 0 && curCol < 0)	{
			if (grid[curRow--][curCol++] == 'Q')
				return false;
		}
		// current column
		curRow = row; curCol = col;
		while (curRow >= 0)	{
			if (grid[curRow--][curCol] == 'Q')
				return false;
		}
		return true;
	}
	
	private static void placeQueens (char[][] grid, int row) {
		if (row == grid.length)	{
			printGrid(grid);
			System.out.println();
			clearGrid (grid);
			return;
		}
		for (int col = 0; col < grid.length; col++)	{
			if (isSafe(grid, row, col))	{
				grid[row][col] = 'Q';
				placeQueens (grid, row+1);
				grid[row][col] = 'o';
			}
		}
	}
	
	private static void placeQueensMain (char[][] grid)	{
		placeQueens (grid, 0);
	}
	
	public static void main (String[] args) {
		char[][] grid = initGrid (5);
		placeQueensMain (grid);
	}
}
