package com.coreds.arrays;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractArraysProblem 
{
	protected static int[] initRandomNumericArray (int size)	{
		return initRandomNumericArray(size, true);
	}
	
	protected static int[] initRandomNumericArrayNoZeroes(int size)	{
		Set<Integer> uniq = new HashSet<>();
		int[] output = new int[size];
		for (int i = 0; i < size; i++)	{
			int rand = (int) (Math.random() * 10);
			while (rand == 0 || uniq.contains(rand))	{
				rand = (int) (Math.random() * 10);
				//System.out.println(rand);
			}
			uniq.add(rand);
			output[i] = rand;
		}
		return output;
	}

	protected static int[] initRandomNumericArrayHalfZeroes(int size)	{
		int[] output = initRandomNumericArray(size, false);
		for (int i = 0; i < size/2; i++)	{
			int rand = (int) (Math.random() * size) % size;
			output[rand] = 0;
		}
		return output;
	}
	
	protected static int[] initRandomNumericArray(int size, boolean dups) {
		Set<Integer> uniq = new HashSet<>();
		int[] output = new int[size];
		for (int i = 0; i < size; i++)	{
			int rand = (int) (Math.random() * size);
			if (dups == false)	{
				while (uniq.contains(rand))	{
					rand = (int) (Math.random() * size);
				}
				uniq.add(rand);
			}
			output[i] = rand;
		}
		return output;
	}
	
	protected static char[] initRandomAlphaNumericArray(int size)	{
		char[] output = new char[size];
		for (int i = 0; i < size; i++)	{
			int rand = (int) (Math.random() * 1000000) % 62;	// [0-9A-Za-z]
			//System.out.println("rand1="+rand);
			if (rand < 10) { rand = rand + 48; }		// 0-9 
			else if (rand < 37) { rand = rand + 65 - 9;	} 	// A-Z	
			else { rand = rand + 97 - 36; }
			//System.out.println("rand2="+rand+" randc="+(char)rand);
			output[i] = (char) rand;
		}
		return output;
	}
	
	protected static void printArray(String s, int[] arr)	{
		System.out.print(s+": {");
		for (int num : arr) System.out.print(num+", ");
		System.out.println("}");
	}
	
	protected static void printArray(String s, char[] arr)	{
		System.out.print(s+": {");
		for (char c : arr) System.out.print(c+", ");
		System.out.println("}");
	}

	protected static void swap (int[] input, int i, int j)	{
		int t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
	
	protected static void swap (char[] input, int i, int j)	{
		char t = input[i];
		input[i] = input[j];
		input[j] = t;
	}

	protected static void swap (String[] input, int i, int j)	{
		String t = input[i];
		input[i] = input[j];
		input[j] = t;
	}
}
