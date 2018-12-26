package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci 
{
	public static void main (String[] args)	{
		fibonacci (10);
	}
	
	private static void fibonacci (int n) {
		int fibo = fibonacciNoMemo (n);
		System.out.println("fibonacci("+n+") = "+fibo);
		int fibo2 = fibonacciWithMemo (n, new HashMap<Integer,Integer>());
		System.out.println("fibonacci with memo("+n+") = "+fibo2);
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