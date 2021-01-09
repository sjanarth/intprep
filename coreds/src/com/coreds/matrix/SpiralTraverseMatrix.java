package com.coreds.matrix;

public class SpiralTraverseMatrix 
{
	public static void main (String[] args) {
		char[][] grid = buildSampleGrid(10,10);
		printGrid(grid);
		spiralTraverse(grid);
	}
	
	private static char[][] buildSampleGrid(int N, int M)	{
		char[][] grid = new char[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				grid[i][j] = getRandomAlphaNumeric();
		return grid;
	}
	
	private static char getRandomAlphaNumeric ()	{
		char[] chars = {
			'0','1','2','3','4','5','6','7','8','9',
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
			'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
		};
		return chars[((int) (Math.random() * 100)) % chars.length];
	}
	
	private static void printGrid(char[][] grid) {
		for (int i = 0; i < grid.length; i++)	{
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void spiralTraverse (char[][] grid) {
		StringBuilder sb = new StringBuilder();
		int N = grid.length, M = grid[0].length;
		int count = N * M;
		int r1 = 0, r2 = N, c1 = 0, c2 = M;
		while (count > 0)	{
			while (count > 0 && c1 < c2) 		{ sb.append(grid[r1][c1]); c1++; count--; } c1--; r1++;
			//System.out.println("1. r1="+r1+", r2="+r2+", c1="+c1+", c2="+c2+", count="+count+", sb="+sb.toString());
			while (count > 0 && r1 < r2)		{ sb.append(grid[r1][c1]); r1++; count--; } c1--; r1--; r2--;
			//System.out.println("2. r1="+r1+", r2="+r2+", c1="+c1+", c2="+c2+", count="+count+", sb="+sb.toString());
			while (count > 0 && c1 >= M-c2)		{ sb.append(grid[r1][c1]); c1--; count--; } c1++; r1--; c2--;    
			//System.out.println("3. r1="+r1+", r2="+r2+", c1="+c1+", c2="+c2+", count="+count+", sb="+sb.toString());
			while (count > 0 && r1 >= N-r2)		{ sb.append(grid[r1][c1]); r1--; count--; } c1++; r1++;  
			//System.out.println("4. r1="+r1+", r2="+r2+", c1="+c1+", c2="+c2+", count="+count+", sb="+sb.toString());
		}
		System.out.println("Spiral Traverse = "+sb.toString());
	}
}
