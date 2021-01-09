package com.coreds.arrays;

public class MoveLettersToLeft extends AbstractArraysProblem
{
	public static void main (String[] args)	{
		char[] input = initRandomAlphaNumericArray (10);
		printArray("input", input);
		moveLettersToLeft(input);
		printArray("input", input);
	}
	
	private static void moveLettersToLeft (char[] input)	{
		int pos = 0;
		for (int i = 0; i < input.length; i++)	{
			int num = input[i] - '0';
			if (num > 10)	{
				swap (input, i, pos);
				pos++;
			}
		}
	}
}
