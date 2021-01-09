package com.coreds.recursion.wip;

public class PalinDecomp	// incomplete 
{
	private static boolean isPalindrome (String s) {
		return s.equals(new StringBuffer(s).reverse().toString());
	}
	
	private static void printPalinDecomps (String s, int pos, String sofar)	{
		if (pos == s.length()) {
			System.out.println(sofar);
		}
		for (int i = pos; i < s.length(); i++)	{
			if (isPalindrome (s.substring(pos,  i)))	{
				if (pos == 0) {
					printPalinDecomps (s, i+1, s.substring(pos, i-pos+1));
				} else {
					System.out.println(i-pos+1);
					printPalinDecomps (s, i+1, sofar + "|" + s.substring(pos, i-pos+1));
				}
			}
		}
	}
	
	private static void printPalinDecompsMain (String s)	{
		printPalinDecomps (s, 0, "");
	}
	
	public static void main (String[] args) {
		printPalinDecompsMain ("abracadabra");
	}
}
