package com.intprep.graphs.problems.wip;

import java.util.HashMap;
import java.util.Map;

public class LongestPathInDAG 
{
	public static void main (String[] args)	{
		Map<Integer,Map<Integer,Integer>> graph = buildSampleGraph();
	}
	
	private static Map<Integer,Map<Integer,Integer>> buildSampleGraph()	{
		Map<Integer,Map<Integer,Integer>> graph = new HashMap<Integer,Map<Integer,Integer>>();
		Map<Integer,Integer> ns1 = new HashMap<Integer,Integer>();
			ns1.put(2,2);
			ns1.put(3,2);
			ns1.put(4,4);
		return graph;
	}
}
