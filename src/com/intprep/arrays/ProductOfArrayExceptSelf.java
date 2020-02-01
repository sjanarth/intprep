package com.intprep.arrays;

public class ProductOfArrayExceptSelf 
{
	public static void main(String[] args) {
		arrayProduct (new int[] {1,2,3,4});
	}
	
	private static void arrayProduct (int[] arr) {
		print ("Given", arr);
		int[] prod = new int[arr.length];
		prod[0] = 1;
		for (int i = 1; i < arr.length; i++)	{
			prod[i] = prod[i-1] * arr[i-1];
		}
		print("Left", prod);
		int right = 1;
		for (int i = arr.length-1; i >= 0; i--)	{
			prod[i] = prod[i] * right;
			right = arr[i] * right;
		}
		print("Prod", prod);
	}
	
	private static void print (String msg, int[] arr) {
		System.out.print(msg+": {");
		for (int i : arr)
			System.out.print(i+",");
		System.out.println("}");
	}
}
