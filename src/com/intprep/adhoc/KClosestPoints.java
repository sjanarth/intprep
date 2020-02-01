package com.intprep.adhoc;

import java.util.Arrays;

public class KClosestPoints 
{
	public static void main(String[] args) {
		findKClosestPoints (new int[][] {{1,3},{-2,2}}, 1);
		findKClosestPoints (new int[][] {{3,3},{5,-1},{-2,4}}, 2);
		findKClosestPoints (new int[][] {{-5,4},{-6,-5},{4,6}}, 2);
		findKClosestPoints (new int[][] {{6,10},{-3,3},{-2,5},{0,2}}, 3);
	}
	
	private static void findKClosestPoints (int[][] points, int k) {
		showPoints ("Input", points);
		int[][] closest = new int[k][2];
		double[] distances = new double[k]; Arrays.fill(distances, Integer.MAX_VALUE);
		for (int i = 0; i < points.length; i++)	{
			showPoint(points[i]);
			double d = Math.sqrt(Math.pow(points[i][0],2) + Math.pow(points[i][1], 2));
			System.out.println(", d="+d);
			for (int j = 0; j < k; j++)	{
				if (distances[j] > d)	{
					for (int m = k-1; m > j; m--)	{
						closest[m] = closest[m-1];
						distances[m] = distances[m-1];
					}
					closest[j] = points[i];
					distances[j] = d;
					break;
				}
			}
		}
		showPoints("Closest "+k+" points", closest);
		System.out.println();
	}
	
	private static void showPoints (String msg, int[][] points)	{
		System.out.print(msg+" = {");
		for (int[] point : points)	
			showPoint(point);
		System.out.println("}");	
	}
	
	private static void showPoint (int[] point)	{
		System.out.print("["+point[0]+","+point[1]+"] ");		
	}
}