package com.intprep.recursion.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * There are n houses built in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value in these houses, but he cannot 
 * steal in two adjacent houses because the owner of a stolen house will tell 
 * his two neighbors on the left and right side. What is the maximal stolen value?
 * 
 * For example, if there are four houses with values [6, 1, 2, 7], 
 * the maximal stolen value is 13 when the first and fourth houses are stolen.
 * 
 * Input Format:
 * 		an array of integer values denoting the value in each house.
 * Output Format:
 * 		an integer denoting the maximum possible robbery.
 */

public class Robbery 
{
	public static void main (String[] args) {
		findMaxRobValue (new int[] {6,1,2,7});
		findMaxRobValue (new int[] {26,1,22,77});
	}
	
	protected static void findMaxRobValue (int[] values) {
		int maxVal = findMaxRobValueNoMemo (values);
		System.out.println("Max rob value "+toString(values)+" = "+maxVal);
		int maxVal2 = findMaxRobValueWithMemo (values);
		System.out.println("Max rob value with memo "+toString(values)+" = "+maxVal2);
	}
	
	private static int findMaxRobValueNoMemo (int[] values) {
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++)	{
			int thisHouse = findMaxRobValueNoMemo (values, i);
			if (thisHouse > maxVal)
				maxVal = thisHouse;
		}
		return maxVal;
	}
	
	private static int findMaxRobValueNoMemo (int[] values, int i) {
		if (i < 0) return 0;
		if (i == 0) return values[0]; 
		if (i == 1) return Math.max(values[0], values[1]);
		return Math.max (findMaxRobValueNoMemo(values, i-1),
							findMaxRobValueNoMemo(values, i-2) + values[i]);
	}
	
	private static int findMaxRobValueWithMemo (int[] values) {
		int maxVal = Integer.MIN_VALUE;
		Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
		for (int i = 0; i < values.length; i++)	{
			int thisHouse = findMaxRobValueWithMemo (values, i, memo);
			if (thisHouse > maxVal)
				maxVal = thisHouse;
		}
		return maxVal;
	}
	
	private static int findMaxRobValueWithMemo (int[] values, int i, Map<Integer,Integer> memo) {
		if (memo.containsKey(i)) return memo.get(i);
		int maxVal = findMaxRobValueNoMemo(values, i);
		memo.put(i, maxVal);
		return maxVal;
	}

	protected static String toString (int[] arr) {
		return Arrays.toString(arr).
					replaceAll("\\[", "\\{").
					replaceAll("\\]", "\\}").
					replaceAll(" ", "");
	}
}