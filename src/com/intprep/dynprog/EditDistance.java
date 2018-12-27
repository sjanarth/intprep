package com.intprep.dynprog;

/*
 * Given two strings s1 and s2 and a set of operations that can performed on s1. 
 * Find minimum number of edits (operations) required to convert s1 to s2.
 * 
 * Insert
 * Remove
 * Replace
 * 
 * All of the above operations are of equal cost.
 */
public class EditDistance extends com.intprep.recursion.problems.EditDistance
{
	public static void main (String[] args) {
		findEditDistance ("bat", "bata");	// insert
		findEditDistance ("bat", "at");		// delete
		findEditDistance ("bat", "cat");		// replace
		findEditDistance ("bat", "boil");		
	}
	
	protected static void findEditDistance (String s1, String s2)	{
		com.intprep.recursion.problems.EditDistance.findEditDistance(s1, s2);
		int ed2 = findEditDistanceUsingDP (s1, s2);
		System.out.println("Edit Distance Using dynprog ("+s1+","+s2+") = "+ed2);
		System.out.println("--------------------------------------------------");
	}
	
	private static int findEditDistanceUsingDP (String s1, String s2) {
		int N = s1.length();
		int M = s2.length();
		// 1. initialize
		int[][] dpt = new int[N+1][M+1];
		// 2. pre-populate
		for (int r = 0; r <= N; r++)
			for (int c = 0; c <= M; c++)
				dpt[r][c] = N+M;
		dpt[0][0] = 0;	
		for (int r = 1; r <= N; r++) dpt[r][0] = r;
		for (int c = 1; c <= M; c++) dpt[0][c] = c;
		// 3. populate
		for (int r = 1; r <= N; r++)	
			for (int c = 1; c <= M; c++)
				if (s1.charAt(r-1) == s2.charAt(c-1)) 
					dpt[r][c] = Math.min(dpt[r][c], dpt[r-1][c-1]);
				else 
					dpt[r][c] = Math.min(dpt[r][c], 
											1 + Math.min(dpt[r-1][c-1],
													Math.min(dpt[r][c-1], dpt[r-1][c])));
		// 4. return
		return dpt[N][M];
	}
}