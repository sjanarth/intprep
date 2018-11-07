package com.intprep.problems;

public class GroupOddEven 
{
	private static int[] groupOddEven (int[] input)	{
		int howManyEven = 0;
		for (int k : input)
			if ((k%2) == 0)
				howManyEven++;
		int[] output = new int[input.length];
		int oddNext = input.length-1;
		int evenNext = howManyEven-1;
		System.out.println ("howManyEven="+howManyEven);
		for (int i = 0; i < input.length; i++)	{
			if ((input[i]%2) == 0)
				output[evenNext--] = input[i];
			else
				output[oddNext--] = input[i];
			printArray("i="+i, output);
		}
		return output;
	}
	
	private static void printArray (String s, int[] arr) {
		System.out.print(s+": ");
		for (int k : arr)
			System.out.print(k+" ");
		System.out.println();
	}
	
	public static void main (String[] args)	{
		int[] input = new int[] {5,5,7,10,2,2,1};
		printArray("Input", input);
		int[] output = groupOddEven (input);
		printArray("Ouput", output);
	}
}
