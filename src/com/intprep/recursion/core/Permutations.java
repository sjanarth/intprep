package com.intprep.recursion.core;

public class Permutations 
{
	private static void swap (char[] chars, int i, int j)	{
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
	}
	
	private static void permute(char[] chars, int i)	{
		if (i == chars.length-1) {
			System.out.println(String.valueOf(chars));
		}
		for (int j = i; j < chars.length; j++)	{
			swap (chars, i, j);
			permute (chars, i+1);
			swap (chars, i, j);
		}
	}
	
	private static void permuteMain (String s) {
		char[] chars = s.toCharArray();
		permute(chars, 0);
	}
	
	public static void main (String[] args) {
		permuteMain ("abcd");
	}
}
