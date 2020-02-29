package com.intprep.arrays;

public class ProductOfArrayExceptSelf extends AbstractArraysProblem 
{
	public static void main(String[] args) {
		arrayProduct (initRandomNumericArrayNoZeroes(5)); //new int[] {1,2,3,4});
	}
	
	private static void arrayProduct (int[] arr) {
		printArray ("Given", arr);
		int[] prod = new int[arr.length];
		prod[0] = 1;
		for (int i = 1; i < arr.length; i++)	{
			prod[i] = prod[i-1] * arr[i-1];
		}
		printArray("Left", prod);
		int right = 1;
		for (int i = arr.length-1; i >= 0; i--)	{
			prod[i] = prod[i] * right;
			right = arr[i] * right;
			printArray ("i="+i, prod);
		}
		printArray("Prod", prod);
	}
}
