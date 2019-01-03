package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci 
{
	public static void main (String[] args)	{
		fibonacci (10);
	}
	
	protected static void fibonacci (int n) {
		long start = System.nanoTime();
		int fibo = fibonacciNoMemo (n);
		long end = System.nanoTime();
		System.out.println("fibonacci("+n+") = "+fibo+" ("+(end-start)/1000000+"millis)");
		start = System.nanoTime();
		int fibo2 = fibonacciWithMemo (n, new HashMap<Integer,Integer>());
		end = System.nanoTime();
		System.out.println("fibonacci with memo("+n+") = "+fibo2+" ("+(end-start)/1000+"micros)");
	}
	
	private static int fibonacciNoMemo (int n) {
		if (n == 0 | n == 1) return 1;
		else return fibonacciNoMemo (n-1) + fibonacciNoMemo (n-2);
	}
	
	private static int fibonacciWithMemo (int n, Map<Integer,Integer> memo) {
		if (memo.containsKey(n))
			return memo.get(n);
		int fib = 0;
		if (n == 0 || n == 1)	{
			fib = 1;
		} else {
			fib = fibonacciWithMemo(n-1, memo) + fibonacciWithMemo(n-2, memo);
		}
		memo.put(n, fib);
		return fib;
	}
}