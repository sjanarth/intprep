package com.intprep.graphs.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort 
{
	public static void main (String[] args) {
		Collection<Vertex<Integer>> graph = buildSampleGraph();
		sortBfs (graph);
		sortDfsMain (graph);
	}
	
	private static List<Vertex<Integer>> buildSampleGraph()	{
		Map<Integer, Vertex<Integer>> allVs = new HashMap<Integer,Vertex<Integer>>();
		for (int i = 0; i < 8; i++)
			allVs.put(i, new Vertex<Integer>(i));
		allVs.get(1).addNeighbor(allVs.get(3));
		allVs.get(2).addNeighbor(allVs.get(3));
		allVs.get(2).addNeighbor(allVs.get(4));
		allVs.get(3).addNeighbor(allVs.get(5));
		allVs.get(4).addNeighbor(allVs.get(6));
		allVs.get(5).addNeighbor(allVs.get(6));
		allVs.get(6).addNeighbor(allVs.get(7));
		List<Vertex<Integer>> graph = new ArrayList<Vertex<Integer>>();
		graph.add(allVs.get(1));
		graph.add(allVs.get(2));
		return graph;
	}
	
	private static void sortBfs (Collection<Vertex<Integer>> graph)	{
		Map<Vertex<Integer>, Integer> indegrees = new HashMap<Vertex<Integer>, Integer>(); 
		Set<Edge<Integer>> visitedEdges = new HashSet<Edge<Integer>>();
		for (Vertex<Integer> v : graph) {
			indegrees.put(v, 0);
			gatherInDegrees (v, indegrees, visitedEdges);
		}
		Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();
		for (Vertex<Integer> v : graph) {
			if (indegrees.get(v) == 0) {
				queue.add(v);
			}
		}
		System.out.println("BFS based sort: ");
		while (!queue.isEmpty()) {
			Vertex<Integer> v = queue.poll();
			System.out.print(v.getLabel()+" ");
			for (Vertex<Integer> n : v.getNeighbors()) {
				int newInDegree = indegrees.get(n)-1;
				indegrees.put(n, newInDegree);
				if (newInDegree == 0)
					queue.add(n);
			}
		}
		System.out.println();
	}
	
	private static void gatherInDegrees (Vertex<Integer> v, Map<Vertex<Integer>, Integer> indegrees, Set<Edge<Integer>> edges){
		for (Vertex<Integer> n : v.getNeighbors())	{
			if (!indegrees.containsKey(n))	{
				indegrees.put(n, 1);
				Edge<Integer> e = new Edge<Integer>(v.getLabel(), n.getLabel());
				edges.add(e);
			} else {
				Edge<Integer> e = new Edge<Integer>(v.getLabel(), n.getLabel());
				if (!edges.contains(e))	{
					indegrees.put(n, indegrees.get(n)+1);
					edges.add(e);
				}
			}
			gatherInDegrees (n, indegrees, edges);
		}
	}
	
	private static void sortDfsMain (Collection<Vertex<Integer>> graph)		{
		Stack<Vertex<Integer>> stack = new Stack<Vertex<Integer>>();
		for (Vertex<Integer> v : graph) {
			sortDfs (v, stack);
		}
		System.out.println("DFS based sort: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getLabel()+" ");
		}
		System.out.println();
	}
	
	private static void sortDfs (Vertex<Integer> v, Stack<Vertex<Integer>> stack) {
		for (Vertex<Integer> n : v.getNeighbors())	{
			sortDfs (n, stack);
		}
		if (!stack.contains(v))
			stack.push(v);
	}
}
