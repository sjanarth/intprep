package com.intprep.realqs;

public class RotateMatrix
{
	private final int[][] mat2x2 = new int[][] {
			{ 1, 2 },
			{ 4, 5 },
		};
	
	private final int[][] mat3x3 = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		};
	
	private final int[][] mat4x4 = new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		};

	public static void main (String[] args)	{
		showMatrix (mat2x2);
	}
	
	private static void showMatrix (int[][] matrix)	{
		for (int i = 0; i < matrix.length; i++)	{
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}