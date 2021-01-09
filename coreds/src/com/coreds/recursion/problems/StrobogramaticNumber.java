package com.coreds.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * Example:
 * 
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 * 
 */
public class StrobogramaticNumber 
{
	public static void main(String[] args) {
		print(getStrobogramaticNumbers(5));
	}
	
	private static List<String> getStrobogramaticNumbers (int n)	{
		return getStrobogramaticNumbers (n, n);
	}
	
	private static List<String> getStrobogramaticNumbers (int n, int m)	{
		if (n == 0)	return new ArrayList<String>(Arrays.asList(""));
		if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		List<String> list = getStrobogramaticNumbers(n-2, m);
		List<String> all = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++)	{
			all.add("0" +list.get(i)+ "0");
			all.add("1" +list.get(i)+ "1");
			all.add("6" +list.get(i)+ "9");
			all.add("8" +list.get(i)+ "8");
			all.add("9" +list.get(i)+ "6");
		}
		return all;
	}
	
	private static void print (List<String> all)	{
		for (String s : all)
			System.out.println(s);
	}
}