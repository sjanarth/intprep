package com.coreds.arrays;

import java.util.Arrays;

/*
 * Leetcode-- https://leetcode.com/explore/interview/card/google/59/array-and-strings/3058/
 * 
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 
 * 
 * There is at least one empty seat, and at least one person sitting.
 * 
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
 * 
 * Return that maximum distance to closest person.
 * 
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation: 
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * 
 * Example 2:
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation: 
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * 
 * Note:
 * 
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */

public class MaxDistToClosestPerson 
{
	public static void main(String[] args) {
		maxDistToClosest(new int[] {1,0,0,0,1,0,1});
		maxDistToClosest(new int[] {1,0,0,0});
	}
	
	public static int maxDistToClosest(int[] seats) {
		System.out.println("maxDist("+Arrays.toString(seats));
		int maxDist = Integer.MIN_VALUE, maxId = -1;
		for (int i = 0; i < seats.length; i++)	{
			if (seats[i] == 0)	{
				int near1 = 1, j = i;
				while (j > 0)	{
					if (seats[j-1] == 1) break;
					j--;
					near1++;
				}
				System.out.println("    i="+i+", near1="+near1+", maxDist="+maxDist+", maxId="+maxId);
				int near2 = 1;
				j = i;
				while (j < seats.length-1)	{
					if (seats[j+1] == 1) break;
					j++;
					near2++;
				}
				System.out.println("    i="+i+", near2="+near2+", maxDist="+maxDist+", maxId="+maxId);
				near1 = Math.min(near1,  near2);
				if (near1 > maxDist)	{
					maxDist = near1;
					maxId = i;
				}
				System.out.println("    i="+i+", near1="+near1+", maxDist="+maxDist+", maxId="+maxId);
			}
			
		}
		System.out.println("maxDist("+Arrays.toString(seats)+") = "+maxDist+", index="+maxId);
		return maxDist;
	}	
}
