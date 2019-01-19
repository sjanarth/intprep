package com.intprep.graphs.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TopologicalSort2 
{
	public static void main (String[] args) {
		Map<String,List<String>> graph = buildSampleGraph();

		System.out.print("BFS = {");
		bfs (graph, "a");
		System.out.println("}");
		
		System.out.print("DFS = {");
		dfs (graph, "a", new HashSet<String>());
		System.out.println("}");

		System.out.print("TS  = {");
		ts (graph);
		System.out.println("}");
	}
	
	private static void bfs(Map<String,List<String>> graph, String start)	{
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		Set<String> visited = new HashSet<String>();
		while(!queue.isEmpty()) {
			String s = queue.poll();
			System.out.print(s+" ");
			visited.add(s);
			List<String> neighbors = graph.get(s);
			if (neighbors != null) {
				for (String n : neighbors)	{
					if (!visited.contains(n))	{
						queue.add(n);
					}
				}
			}
		}
	}
	
	private static void dfs(Map<String,List<String>> graph, String start, Set<String> visited) {
		System.out.print(start+" ");
		visited.add(start);
		List<String> neighbors = graph.get(start);
		if (neighbors != null) {
			for (String n : neighbors) {
				if (!visited.contains(n))	{
					dfs (graph, n, visited);
				}
			}
		}
	}
	
	private static void ts (Map<String,List<String>> graph) {
		Map<String,Integer> indegrees = new HashMap<String,Integer>();
		for (String s : graph.keySet())	{
			if (!indegrees.containsKey(s)) indegrees.put(s, 0);
			List<String> neighbors = graph.get(s);
			if (neighbors != null) {
				for (String n : neighbors) {
					Integer c = indegrees.get(n);
					if (c == null) c = 0;
					c++;
					indegrees.put(n, c);
				}
			}
		}
		Queue<String> queue = new LinkedList<String>();
		for (String s : graph.keySet()) {
			if (indegrees.get(s) == 0)	{
				queue.add(s);
			}
		}
		while(!queue.isEmpty()) {
			String s = queue.poll();
			System.out.print(s+" ");
			List<String> neighbors = graph.get(s);
			if(neighbors != null)	{
				for (String n : neighbors) {
					int indg = indegrees.get(n);
					indg--;
					indegrees.put(n, indg);
					if (indg == 0) queue.add(n);
				}
			}
		}
	}
	
	private static Map<String,List<String>> buildSampleGraph()	{
		Map<String,List<String>> graph = new HashMap<String,List<String>>();
		List<String> a = new ArrayList<String>();
		a.add("b"); a.add("c");
		graph.put("a", a);
		List<String> b = new ArrayList<String>();
		b.add("d");
		graph.put("b", b);
		List<String> c = new ArrayList<String>();
		c.add("b");
		graph.put("c", c);
		return graph;
	}
}
