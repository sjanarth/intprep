package com.intprep.arrays;

import java.util.Arrays;

public class TopKPoints 
{
	public static void main (String[] args)	{
		findTopK (8, new int[] {0,0}, getRandomPoints(50));
	}
	
	private static void findTopK(int K, int[] start, int[][] points) {
		printArray("Input", points);
		int[] topKdists = new int[K];
		Arrays.fill(topKdists, Integer.MAX_VALUE);
		int[][] topKpoints = new int[K][2];
		for (int i = 0; i < K; i++) Arrays.fill(topKpoints[i], 0);
		for (int i = 0; i < points.length; i++)	{
			int dist = getDistance(start, points[i]);
			addReplace(topKdists, topKpoints, dist, points[i]);
			printArray2("Top "+K+" elements = ", topKpoints, topKdists);
		}
		printArray2("Top "+K+" elements = ", topKpoints, topKdists);
	}
	
	private static void addReplace(int[] topKdists, int[][] topKpoints, int dist, int[] point) {
		for (int i = 0; i < topKdists.length; i++)	{
			if (dist < topKdists[i])	{
				//System.out.println("Moving from "+(topKdists.length-2)+" to "+i);
				for (int j = topKdists.length-2; j > i; j--) {
					topKdists[j+1] = topKdists[j];
					topKpoints[j+1][0] = topKpoints[j][0];					
					topKpoints[j+1][1] = topKpoints[j][1];
				}
				topKdists[i] = dist;
				topKpoints[i][0] = point[0];
				topKpoints[i][1] = point[1];
				break;
			}
		}
	}
	
	private static int getDistance (int[] start, int[] end)	{
		return (int) (Math.pow((double) (end[0] - start[0]), 2) + Math.pow((double) (end[1] - start[1]), 2));
	}
	
	private static int[][] getRandomPoints(int n)	{
		int[][] points = new int[n][2];
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[0].length; j++) {
				points[i][j] = ((int) (Math.random()*100)) % 64;
			}
		}
		return points;
	}
	
	private static void printArray2(String s, int[][] arr, int[] dists)	{
		StringBuilder sb = new StringBuilder(s+" = {");
		sb.append(formatArray(arr[0])); sb.append(":"); sb.append(dists[0]);
		for (int i = 1; i < arr.length; i++)	{
			sb.append(","); 
			sb.append(formatArray(arr[i]));
			sb.append(":");
			sb.append(dists[i]);
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	private static void printArray(String s, int[][] arr)	{
		StringBuilder sb = new StringBuilder(s+" = {");
		sb.append(formatArray(arr[0]));
		for (int i = 1; i < arr.length; i++)	{
			sb.append(","); 
			sb.append(formatArray(arr[i]));
		}
		sb.append("}");
		System.out.println(sb.toString());
	}
	
	private static String formatArray(int[] arr) {
		return Arrays.toString(arr).
				replaceAll(" ", "").
				replaceAll("\\[", "\\{").
				replaceAll("\\]", "\\}");
	}
}
