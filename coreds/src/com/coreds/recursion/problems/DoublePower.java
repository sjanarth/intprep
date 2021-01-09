package com.coreds.recursion.problems;

public class DoublePower 
{
	public static void main (String[] args)	{
		doublePower(156565786866868668686868686868d, 5);
	}
	
	private static void doublePower(double d, int i)	{
		System.out.println("Math.pow("+d+","+i+") = "+Math.pow(d, i));
		double d2 = pow(d, i);
		System.out.println("doublePower("+d+","+i+") = "+d2);
	}
	
	private static double pow (double d, int i)	{
		if (i == 0) return 1;
		return d * pow(d,i-1);
	}
}
