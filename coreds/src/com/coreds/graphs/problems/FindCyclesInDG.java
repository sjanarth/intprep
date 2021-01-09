package com.coreds.graphs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCyclesInDG 
{
	public static void main(String[] args)	{
		Node cyclic = buildCyclicGraph();
		System.out.println("isCyclic(cylic-graph) = "+isCyclic(cyclic));
		Node noncyclic = buildNonCyclicGraph();
		System.out.println("isCyclic(non-cylic-graph) = "+isCyclic(noncyclic));
	}
	
	private static class Node {
		Integer data;
		List<Node> neighbours = new ArrayList<Node>();
		Node (int d) { data = d; }
	}
	
	private static boolean isCyclic (Node node) {
		Set<Integer> visiting = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		return isCyclic (node, visiting, visited);
	}
	
	private static boolean isCyclic (Node node, Set<Integer> visiting, Set<Integer> visited)	{
		visiting.add(node.data);
		for (Node n : node.neighbours)	{
			if (visited.contains(n.data)) continue;
			if (visiting.contains(n.data)) return true;
			if (isCyclic (n, visiting, visited)) return true;
		}
		visiting.remove(node.data);
		visited.add(node.data);
		return false;
	}
	
	private static Node buildCyclicGraph()	{
		Node n1 = new Node(1);
		Node n2 = new Node(2); 
		Node n3 = new Node(3);
		n1.neighbours.add(n2);
		n2.neighbours.add(n3);
		n3.neighbours.add(n1);
		return n1;
	}
	
	private static Node buildNonCyclicGraph()	{
		Node n1 = new Node(1);
		Node n2 = new Node(2); 
		Node n3 = new Node(3);
		n1.neighbours.add(n2);
		n2.neighbours.add(n3);
		//n3.neighbours.add(n1);
		return n1;
	}
}