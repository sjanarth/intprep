package com.coreds.dynprog;

public class Fibonacci extends com.coreds.recursion.problems.Fibonacci
{
	public static void main (String[] args)	{
		fibonacci(45);
	}
	
	protected static void fibonacci (int n) {
		com.coreds.recursion.problems.Fibonacci.fibonacci(n);
		long start = System.nanoTime();
		int fib = fibonacciUsingDP(n);
		long end = System.nanoTime();
		System.out.println("fibonacci with dynprog("+n+") = "+fib+" ("+(end-start)/1000+"micros)");
	}
	
	private static int fibonacciUsingDP (int n) {
		// 1. intialize
		int[] dpt = new int[n+1];
		// 2. pre-populate
		dpt[0] = 1;
		dpt[1] = 1;
		// 3. populate
		for (int i = 2; i <= n; i++)	{
			dpt[i] = dpt[i-1] + dpt[i-2];
		}
		// 4. return
		return dpt[n];
	}
}
