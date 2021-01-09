package com.coreds.recursion.problems;

public class Permutations 
{
	public static void main (String[] args) {
		permuteMain ("abcd");
	}

	private static void permuteMain (String s) {
		char[] chars = s.toCharArray();
		permute(chars, 0);
	}
	
	private static void permute(char[] chars, int i)	{
		if (i == chars.length-1) {
			print(String.valueOf(chars));
		}
		for (int j = i; j < chars.length; j++)	{
			swap (chars, i, j);
			permute (chars, i+1);
			swap (chars, i, j);
		}
	}
	
	private static void print (String s) {
		count++;
		System.out.println(count+". ["+s+"]");
	}
	
	private static int count = 0;
	
	private static void swap (char[] chars, int i, int j)	{
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}
}