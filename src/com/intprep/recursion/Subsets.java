package com.intprep.recursion;

public class Subsets 
{
	private static void print (char[] chars, int k)	{
		System.out.print("{");
		for (int i = 0; i < k; i++)	{
			System.out.print(chars[i]);
		}
		System.out.println("}");
	}
	
	private static void printSubsets (char[] input, int i, char[] output, int k)	{
		if (i == input.length) {
			print (output, k);
		} else {
			printSubsets (input, i+1, output, k);
			output[k] = input[i];
			printSubsets (input, i+1, output, k+1);
		}
	}
	
	private static void printSubsetsMain (String s) {
		char[] chars = s.toCharArray();
		char[] output = new char[chars.length];
		printSubsets (chars, 0, output, 0);
	}
	
	public static void main (String[] args) {
		printSubsetsMain ("abcd");
	}
}
