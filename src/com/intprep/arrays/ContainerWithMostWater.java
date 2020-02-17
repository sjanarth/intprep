package com.intprep.arrays;

/*
 * Leetcode 3048 -- https://leetcode.com/explore/interview/card/google/59/array-and-strings/3048/
 * 
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2.
 * 
 * Example:
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 */

public class ContainerWithMostWater 
{
	public static void main (String[] args)	{
		System.out.println("Max area = "+maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
	
	// o(n)
	private static int maxArea (int[] heights)	{
		int maxArea = Integer.MIN_VALUE;
		int left = 0, right = heights.length-1;
		while (left < right)	{
			int min = Math.min(heights[left],  heights[right]);
			maxArea = Math.max(maxArea, min * (right-left));
			if (heights[left] < heights[right]) left++;
			else right--;
		}
		return maxArea;
	}
	
	// o(n2)
	private static int maxArea2 (int[] heights)	{
		int maxArea = Integer.MIN_VALUE;
		for (int i = 0; i < heights.length-1; i++)	{
			for (int j = i+1; j < heights.length; j++)	{
				int min = Math.min(heights[i], heights[j]);
				maxArea = Math.max(maxArea, min* (j-i));
			}
		}
		return maxArea;
	}
}
