package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class FindCycles 
{
	public static void main(String[] args)	{
		Node cyclic = buildCyclicGraph();
		isCyclic(cyclic);
		Node noncyclic = buildNonCyclicGraph();
		isCyclic(noncyclic);
	}
	
	private static class Node {
		Integer data;
		List<Node> neighbours = new ArrayList<Node>();
		Node (int d) { data = d; neighbours.clear(); }
	}
	
	private static void isCyclic (Node node) {
		boolean isCyclic = isCyclic(node, new Stack<Node>(), new HashSet<Node>());
		System.out.println();
		System.out.println("Cycle = "+isCyclic);
	}
	
	private static boolean isCyclic (Node node, Stack<Node> stack, Set<Node> visited) {
		if (stack.contains(node)) 
			return true;
		if (!visited.contains(node))	{
			System.out.print(node.data+" ");
			stack.push(node);
			visited.add(node);
			if (node.neighbours != null)	{
				for (Node n : node.neighbours)	{
					if (isCyclic(n, stack, visited))
						return true;
				}
			}
			stack.remove(node);
		}
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
