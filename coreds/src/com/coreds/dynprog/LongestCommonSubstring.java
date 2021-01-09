package com.coreds.dynprog;

/*
 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 */

public class LongestCommonSubstring 
{
	public static void main (String[] args)	{
		findLCS ("YOURSELF", "MYSELF");
	}
	
	private static void findLCS (String s1, String s2)	{
		String lcs = findLCS(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
		System.out.println("Longest Common Substring ("+s1+","+s2+") = "+lcs);
	}
	
	private static String findLCS (char[] X, char[] Y, int m, int n)	{
		// 1. initialize
		int[][] dpt = new int[m+1][n+1];
		// 2. pre-populate
		for (int i = 0; i <= m; i++) dpt[i][0] = 0;
		for (int j = 0; j <= n; j++) dpt[0][j] = 0;
		// 3. populate
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X[i-1] == Y[j-1]) 
					dpt[i][j] = dpt[i-1][j-1] + 1;
				else 
					dpt[i][j] = 0; 
			}
		}
		// 4. return
		int index = dpt[m][n];
		int temp = index;
		char[] lcs = new char[index+1];
		lcs[index] = ' ';
		int i = m, j = n;
		while (i > 0 && j > 0)	{
			if (X[i-1] == Y[j-1])	{
				lcs[index-1] = X[i-1];
				i--;
				j--;
				index--;
			} else if (dpt[i-1][j] > dpt[i][j-1]) {
				i--;
			} else {
				j--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k <= temp; k++)
			sb.append(lcs[k]);
		return sb.toString();
	}
}