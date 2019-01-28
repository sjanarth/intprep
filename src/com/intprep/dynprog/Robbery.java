package com.intprep.dynprog;

public class Robbery extends com.intprep.recursion.problems.Robbery 
{
	public static void main (String[] args) {
		findMaxRobValue (new int[] {6,1,2,7});
		findMaxRobValue (new int[] {26,1,22,77});
	}
	
	protected static void findMaxRobValue (int[] values) {
		com.intprep.recursion.problems.Robbery.findMaxRobValue(values);
		int maxVal = findMaxRobValueUsingDP (values);
		System.out.println("Max rob value using dynprog "+toString(values)+" = "+maxVal);
		System.out.println("----------------------------------------------------------------");
	}
	
	private static int findMaxRobValueUsingDP (int[] values) {
		// 1. initialize
		int N = values.length;
		int[] dpt = new int[N];
		for (int i = 0; i < N; i++) dpt[i] = Integer.MIN_VALUE;
		// 2. pre-populate
		dpt[0] = values[0];
		dpt[1] = Math.max(values[0], values[1]);
		// 3. populate
		for (int i = 2; i < N; i++) 
			dpt[i] = Math.max (dpt[i-1], dpt[i-2]+values[i]);
		// 4. return
		return dpt[N-1]; 
	}
}
