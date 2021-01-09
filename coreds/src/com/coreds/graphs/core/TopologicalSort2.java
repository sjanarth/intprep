package com.coreds.graphs.core;

import java.util.*;

public class TopologicalSort2 
{
	public static void main (String[] args) {
		Map<String,List<String>> graph = buildSampleGraph();

		System.out.print("BFS = {");
		bfs (graph);
		System.out.println("}");
		
		System.out.print("DFS = {");
		dfs (graph);
		System.out.println("}");

		System.out.print("TS  = {");
		ts (graph);
		System.out.println("}");
	}
	
	private static void bfs(Map<String,List<String>> graph)	{
		Set<String> visited = new HashSet<String>();
		for (String v : graph.keySet()) {
			if (visited.contains(v)) 
				continue;
			Queue<String> queue = new LinkedList<String>();
			queue.add(v);
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
	}
	
	private static void dfs(Map<String,List<String>> graph) {
		Set<String> visited = new HashSet<String>();
		for (String v : graph.keySet()) {
			dfsUtil (graph, v, visited);
		}
	}
	
	private static void dfsUtil (Map<String,List<String>> graph, String v, Set<String> visited)	{
		if (visited.contains(v)) 
			return;
		System.out.print(v+" ");
		visited.add(v);
		List<String> neighbors = graph.get(v);
		if (neighbors != null) {
			for (String n : neighbors) {
				if (!visited.contains(n))	{
					dfsUtil (graph, n, visited);
				}
			}
		}
	}
	
	private static void ts (Map<String,List<String>> graph) {
		Stack<String> stack = new Stack<String>();
		for (String v : graph.keySet())
			tsUtil(graph, v, stack);
		while (!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	
	private static void tsUtil (Map<String,List<String>> graph, String v, Stack<String> stack) {
		List<String> neighbors = graph.get(v);
		if (neighbors != null)	{
			for (String n : neighbors)	{
				tsUtil (graph, n, stack);
			}
		}
		if (!stack.contains(v))
			stack.push(v);
	}
	
	private static void ts2 (Map<String,List<String>> graph) {
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
