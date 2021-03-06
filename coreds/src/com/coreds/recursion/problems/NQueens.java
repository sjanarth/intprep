package com.coreds.recursion.problems;

import java.util.Arrays;

public class NQueens 
{
	private static final char QUEEN = 'Q';
	private static final char NO_QUEEN = '-';
	
	public static void main (String[] args) {
		char[][] grid = initGrid (7);
		placeQueensMain (grid);
	}

	private static char[][] initGrid (int size)	{
		char[][] grid = new char[size][size];
		for (int i = 0; i < grid.length; i++)
			Arrays.fill(grid[i], NO_QUEEN);
		return grid;
	}
	
	private static void placeQueensMain (char[][] grid)	{
		placeQueens (grid, 0);
	}
	
	private static void placeQueens (char[][] grid, int row) {
		if (row == grid.length)	{
			printGrid (grid);
			System.out.println();
			return;
		}
		for (int col = 0; col < grid.length; col++)	{
			if (isSafe(grid, row, col))	{
				grid[row][col] = QUEEN;
				placeQueens (grid, row+1);
				grid[row][col] = NO_QUEEN;
			}
		}
	}
	
	private static void printGrid (char[][] grid) {
		System.out.println("**** Solution-"+(++countOfSolutions));
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
			if (grid[curRow--][curCol--] == QUEEN)
				return false;
		}
		// top-right to bottom-left diagonal
		curRow = row; curCol = col;
		while (curRow >= 0 && curCol < grid.length)	{
			if (grid[curRow--][curCol++] == QUEEN)
				return false;
		}
		// current column
		curRow = row; curCol = col;
		while (curRow >= 0)	{
			if (grid[curRow--][curCol] == QUEEN)
				return false;
		}
		return true;
	}
	
	private static int countOfSolutions = 0;
}