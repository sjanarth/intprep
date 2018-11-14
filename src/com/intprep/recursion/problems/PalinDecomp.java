package com.intprep.recursion.problems;

public class PalinDecomp 
{
	private static boolean isPalinDrome (String s) {
		return s.equals(new StringBuffer(s).reverse().toString());
	}
	
	private static void printPalinDecomps (String s, int size) {
		
	}
	
	private static void printPalinDecompsMain (String s)	{
		for (int i = 1; i < s.length(); i+=2) {
			printPalinDecomps (s, i);
		}
	}
	
	public static void main (String[] args) {
		printPalinDecompsMain ("abracadabra");
	}
}
