package com.intprep.graphs.problems;

import java.util.ArrayList;
import java.util.List;

public class FindCycles 
{
	public static void main(String[] args)	{
		Node cyclic = buildCyclicGraph();
		findCycle(cyclic);
		Node noncyclic = buildNonCyclicGraph();
		findCycle(noncyclic);
	}
	
	private static class Node {
		Integer data;
		List<Node> neighbours = new ArrayList<Node>();
		Node (int d) { data = d; neighbours.clear(); }
	}
	
	private static void findCycle (Node n1) {
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
