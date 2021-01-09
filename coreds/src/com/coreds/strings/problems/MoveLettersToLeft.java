package com.coreds.strings.problems;

public class MoveLettersToLeft 
{
	public static void main (String[] args) {
		moveLettersToLeft ("0a193zbr");	
	}
	
	private static String moveLettersToLeft (String s) {
		char[] input = s.toCharArray();
		int id = 0;
		for (int i = 0; i < input.length; i++) {
			if (!isDigit(input[i]))	{
				if (i != id) input[id] = input[i];
				id++;
			}
		}
		String s2 = String.valueOf(input);
		System.out.println(s+" => "+s2);
		return s2;
	}
	
	private static boolean isDigit (char ch) {
		return ch >= '0' && ch <= '9';
	}
}