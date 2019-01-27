package com.intprep.strings.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordIndices 
{
	public static void main(String[] args)	{
		findWordIndices ("you are very very smart", new String[] {"you", "are", "very", "handsome"});
	}
	
	private static void findWordIndices (String text, String[] words)	{
		Map<String,List<Integer>> indices = parseText(text);
		System.out.println("Text = "+text);
		for (String w : words)	{
			System.out.print(w+" => {");
			List<Integer> thisIndex = indices.get(w);
			if (thisIndex != null) {
				for (Integer i : thisIndex) System.out.print(i+",");
			}
			System.out.println("}");
		}
	}
	
	private static Map<String,List<Integer>> parseText(String s)	{
		Map<String,List<Integer>> indices = new HashMap<String,List<Integer>>();
		String[] splits = s.split(" ");
		int curPos = 0;
		for (int i = 0; i < splits.length; i++)	{
			List<Integer> thisIndex = indices.get(splits[i]);
			if(thisIndex == null) thisIndex = new ArrayList<Integer>();
			System.out.println("Found "+splits[i]+" at index "+curPos);
			thisIndex.add(curPos);
			curPos = curPos + splits[i].length();
			indices.put(splits[i], thisIndex);
		}
		return indices;
	}
}
