package com.intprep.sorting.problems;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string array named arr of size N containing KEYS 
 * and VALUES separated by one space, where KEYS and VALUES can repeat. 
 * Your task is to find, for each unique key, the number of values with 
 * that key and the value with the highest lexicographical order 
 * (also called alphabetical order and dictionary order).
 * 
 * Example:
 * Input:
 * arr = [
 * 		“key1 abcd”,
 * 		“key2 zzz”,
 * 		“key1 hello”,
 * 		“key3 world”,
 * 		"key1 hello"
 * ]
 * Output:
 * [
 * 		"key1:3,hello",
 * 		"key2:1,zzz",
 * 		"key3:1,world"
 * ]
 */

public class CountAndLargest 
{
	private static String[] getCountAndLargest (String[] input) {
		Map<String,String> map = new HashMap<String, String>();
		for (String s : input)	{
			String key = s.split(" ")[0];
			String value = s.split(" ")[1];
			String countAndLargest = map.get(key);
			Integer count = 0;
			String largest = "";
			if (countAndLargest != null)	{
				count = Integer.parseInt(countAndLargest.split(",")[0]);
				count++;
				largest = countAndLargest.split(",")[1];
				if (largest.compareTo(value) < 0)	{
					largest = value;
				}
			} else {
				count++;
				largest = value;
			}
			map.put(key, count+","+largest);
		}
		String[] output = new String[map.size()];
		int i = 0;
		for (String key : map.keySet()) {
			output[i++] = key+":"+map.get(key);
		}
		return output;
	}
	
	public static void main (String[] args)	{
		String[] input = {
		  "key1 abcd",
		  "key2 zzz",
		  "key1 hello",
		  "key3 world",
		  "key1 hello"				
		};
		String[] output = getCountAndLargest(input);
		for (String s : output)
			System.out.println(s);
	}
}
