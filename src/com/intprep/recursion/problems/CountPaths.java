package com.intprep.recursion.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a M x N grid, a start and an end point, find all paths to the end point.
 * You are allowed to traverse the grid one step at a time either down or to the right.
 */

public class CountPaths
{
	public static void main (String[] args) {
		for (int i = 2; i < 10; i++)
			countPaths(0, 0, i, i);
	}

	protected static void countPaths (int startX, int startY, int endX, int endY) {
		int count = countPathsNoMemo (startX, startY, endX, endY);
		System.out.println("countPaths("+startX+","+startY+","+endX+","+endY+") no memo = "+count);
		Map<String,Integer> memo = new HashMap<String,Integer>();
		int count2 = countPathsWithMemo (startX, startY, endX, endY, memo);
		System.out.println("countPaths("+startX+","+startY+","+endX+","+endY+") with memo = "+count2);
	}
	
	private static int countPathsNoMemo (int startX, int startY, int endX, int endY)	{
		if (startX > endX || startY > endY)	
			return 0;
		if (startX == endX && startY == endY)
			return 1;
		return countPathsNoMemo (startX+1, startY, endX, endY) + 
				countPathsNoMemo (startX, startY+1, endX, endY);
	}

	private static int countPathsWithMemo (int startX, int startY, int endX, int endY, Map<String,Integer> memo)	{
		if (startX > endX || startY > endY)	
			return 0;
		if (startX == endX && startY == endY)
			return 1;
		String key = startX + "," + startY;
		if (memo.containsKey(key)) return memo.get(key);
		int count = countPathsWithMemo (startX+1, startY, endX, endY, memo) + 
				countPathsWithMemo (startX, startY+1, endX, endY, memo);
		memo.put(key, count);
		return count;
	}

}
