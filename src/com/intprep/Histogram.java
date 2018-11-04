package com.intprep;

import java.util.LinkedHashMap;
import java.util.Map;

public class Histogram {
	
	private static Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
	private static Integer max = 0;
	private static Integer unique = 0;
	private static int[][] matrix = null;
	
	private static void populate (int[] nums)	{
		for (int i = 0; i < nums.length; i++)	{
			Integer count = map.get(nums[i]);
			if (count == null)	{
				count = 0;
				unique++;
			}
			count++;
			if (count > max)
				max = count;
			map.put(nums[i],  count);
		}
	}
	
	private static void buildMatrix ()	{
		matrix = new int[max][unique];
		int col = 0;
		for (Integer k : map.keySet())	{
			Integer v = map.get(k);
			System.out.println("BuildMatrix: k="+k+",v="+v);
			for (int row = max-1; row >= 0; row--, v--)	{
				matrix[row][col] = v > 0 ? 1 : 0; 
			}
			col++;
		}
	}
	
	private static void print ()	{
		System.out.println("Max: "+max);
		System.out.println("Unique: "+unique);
		for (int row = 0; row < max; row++)	{
			System.out.print(max-row+"|");
			for (int col = 0; col < unique; col++)	{
				System.out.print(matrix[row][col] > 0 ? "*" : " ");
			}
			System.out.println();
		}
		System.out.print("-|");
		for (Integer k : map.keySet())
			System.out.print(k);
	}
	
	private static void printHistogram (int[] nums)	{
		populate (nums);
		buildMatrix ();
		print();
	}

	public static void main(String[] args) {
		printHistogram (new int[] {3,2,2,4,5,3,5,2,7,7,7,7,7,7,7});
	}
}
