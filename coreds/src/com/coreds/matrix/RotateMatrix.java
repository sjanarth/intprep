package com.coreds.matrix;

public class RotateMatrix
{
	private static final int[][] mat2x2 = new int[][] {
			{ 1, 2 },
			{ 4, 5 },
		};
	
	private static final int[][] mat3x3 = new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		};
	
	private static final int[][] mat4x4 = new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		};

	public static void main (String[] args)	{
		showMatrix (mat3x3);
		rotateMatrixCounterClockwise (mat3x3);
		System.out.println("After rotateMatrixCounterClockwise");
		showMatrix(mat3x3);
		System.out.println();
		showMatrix (mat4x4);
		rotateMatrixClockwise (mat4x4);
		System.out.println("After rotateMatrixClockwise");
		showMatrix(mat4x4);
	}
	
	private static void rotateMatrixClockwise(int[][] matrix)	{
		transpose (matrix);
		reverseRows(matrix);
	}
	
	private static void rotateMatrixCounterClockwise(int[][] matrix) {
		transpose (matrix);
		reverseColumns(matrix);
	}
	
	// Assumes a square matrix
	private static void transpose (int[][] matrix)	{
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++)	{
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
				//System.out.println("i = "+i+", j = "+j);
				//showMatrix(matrix);
			}
		}
		System.out.println("After transpose");
		showMatrix(matrix);
	}
	
	private static void reverseRows (int[][] matrix)		{
		int N = matrix.length;
		for (int row = 0; row < N; row++)	{
			for (int col = 0; col < N / 2; col++)	{
				int temp = matrix[row][col];
				matrix[row][col] = matrix[row][N-col-1];
				matrix[row][N-col-1] = temp;
			}
		}
		//System.out.println("After reverseRows");
		//showMatrix(matrix);
	}

	private static void reverseColumns (int[][] matrix)		{
		int N = matrix.length;
		for (int row = 0; row < N / 2; row++)	{
			for (int col = 0; col < N; col++)	{
				int temp = matrix[row][col];
				matrix[row][col] = matrix[N-row-1][col];
				matrix[N-row-1][col] = temp;
			}
		}
		//System.out.println("After reverseColumns");
		//showMatrix(matrix);
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