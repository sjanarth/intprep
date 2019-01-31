package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * Three arguments for function, N, M and 2D Array of size M*2 where N denotes 
 * number of vertices and M denotes number of directed edges and 2D array of 
 * size M*2 represent M directed edges.
 * 
 * For array of size M*2, each row will represent directed edge, where value 
 * in column 1 and column 2 will be index (0-based) of starting vertex and 
 * ending vertex respectively of that directed edge.
 */
public class FindCycles2 
{
	public static void main(String[] args) {
		boolean hasCycle = hasCycle(5, 7, buildSampleGraph());
		System.out.println();
		System.out.println("hasCycle = "+hasCycle);
	}
	
	public static boolean hasCycle(int N, int M, List<List<Integer>> edges) {
		Map<Integer,List<Integer>> graph = edgesToGraph(edges);
		return hasCycle(graph);
	}
	
	private static boolean hasCycle (Map<Integer,List<Integer>> graph)	{
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer,Integer> backRefs = new HashMap<Integer,Integer>();
		for (Integer i : graph.keySet()) 
			if (hasCycle(i, graph, stack, visited, backRefs))
				return true;
		return false;
	}
	
	private static boolean hasCycle (Integer i, 
									Map<Integer,List<Integer>> graph, 
									Stack<Integer> stack, 
									Set<Integer> visited, 
									Map<Integer,Integer> backRefs)	{
		if (stack.contains(i)) {
			System.out.println();
			printCycle(backRefs, i);
			return true;
		}
		if (!visited.contains(i))	{
			System.out.print(i+" ");
			stack.push(i);
			visited.add(i);
			if (graph.containsKey(i))	{
				for (Integer n : graph.get(i))	{
					backRefs.put(n, i);
					if (hasCycle(n, graph, stack, visited, backRefs))
						return true;
				}
			}
			stack.remove(i);
		}
		return false;
	}
	
	private static void printCycle (Map<Integer,Integer> backRefs, Integer i)	{
		StringBuilder sb = new StringBuilder();
		Integer curr = i;
		Set<Integer> visited = new HashSet<Integer>();
		while (!visited.contains(curr)) {
			sb.append(curr+" ");
			visited.add(curr);
			curr = backRefs.get(curr);
		}
		System.out.println(sb.reverse().toString());
	}
	
	private static Map<Integer,List<Integer>> edgesToGraph (List<List<Integer>> edges)	{
		Map<Integer,List<Integer>> graph = new HashMap<Integer,List<Integer>>();
		for (List<Integer> e : edges) {
			Integer u = e.get(0);
			Integer v = e.get(1);
			List<Integer> neighbors = graph.get(u);
			if (neighbors == null) neighbors = new ArrayList<Integer>();
			if (!neighbors.contains(v)) neighbors.add(v);
			graph.put(u, neighbors);
		}
		return graph;
	}
	
	private static List<List<Integer>> buildSampleGraph ()	{
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		List<Integer> e1 = new ArrayList<Integer>(); e1.add(0); e1.add(1); edges.add(e1);
		List<Integer> e2 = new ArrayList<Integer>(); e2.add(1); e2.add(3); edges.add(e2);
		List<Integer> e3 = new ArrayList<Integer>(); e3.add(2); e3.add(3); edges.add(e3);
		List<Integer> e4 = new ArrayList<Integer>(); e4.add(1); e4.add(2); edges.add(e4);
		List<Integer> e5 = new ArrayList<Integer>(); e5.add(4); e5.add(1); edges.add(e5);
		List<Integer> e6 = new ArrayList<Integer>(); e6.add(0); e6.add(4); edges.add(e6);
		List<Integer> e7 = new ArrayList<Integer>(); e7.add(3); e7.add(0); edges.add(e7);
		return edges;
	}
}
