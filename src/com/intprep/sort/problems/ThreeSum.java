package com.intprep.sort.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSum 
{
	static String getString (int a, int b, int c)	{
		if (a < b)	{
			if (b < c)	{
				return a + "," + b + "," + c;
			} else {
				return a + "," + c + "," + b;
			}
		} else {
			if (a < c)	{
				return b + "," + a + "," + c;
			} else {
				return b + "," + c + "," + a;
			}
		}
	}
	
	static String[] findZeroSum(int[] arr) {
		Map<Integer,Integer> input = new HashMap<Integer,Integer>();
		for (int i = 0; i < arr.length; i++) {
			input.put(arr[i], i);
		}
		Set<String> triplets = new HashSet<String>(); 
		for (int i = 0; i < arr.length; i++)	{
			for (int j = 0; j < arr.length; j++)	{
				if (i == j) continue;
				int complementOfSum = -1 * (arr[i]+arr[j]);
				System.out.println("arr[i]="+arr[i]+",arr[j]="+arr[j]+",cOS="+complementOfSum);
				//if (input.contains(complementOfSum))	{
					triplets.add(getString(arr[i],arr[j],complementOfSum));
				//}
			}
		}
		return triplets.toArray(new String[0]);
	}
	
	public static void main (String[] args) {
		String[] sums = findZeroSum(new int[] {3,0,0,0});
		for (String s : sums)
			System.out.println(s);
	}
}
