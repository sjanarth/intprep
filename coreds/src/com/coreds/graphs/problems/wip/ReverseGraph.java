package com.coreds.graphs.problems.wip;

import java.util.*;

public class ReverseGraph 
{
	public static void main(String[] args) {
		Node graph = buildSampleGraph();
		printGraph(graph);
		System.out.println("Reversed graph:");
		Node graph2 = reverseGraph(graph);
		printGraph(graph2);
	}
	
	private static class Node {
		Integer data;
		Vector<Node> neighbours = new Vector<Node>();
		Node (int d) { data = d; neighbours.clear(); }
	}
	
	private static Node reverseGraph(Node node)	{
		return new Node(1);
	}
	
	private static void printGraph(Node node) {
		Set<Node> visited = new HashSet<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.data+" => {");
			for (Node n : curr.neighbours) {
				System.out.print(n.data+",");
				if (!visited.contains(n) && !queue.contains(n)) queue.add(n);
			}
			System.out.println("}");
			visited.add(curr);
		}
	}
	
	private static Node buildSampleGraph()	{
		Node n6 = new Node(6);
		Node n5 = new Node(5); n5.neighbours.addElement(n6);
		Node n4 = new Node(4); n4.neighbours.addElement(n6);
		Node n3 = new Node(3); n3.neighbours.addElement(n5);
		Node n2 = new Node(2); n2.neighbours.addElement(n3); n2.neighbours.addElement(n4);
		Node n1 = new Node(1); n1.neighbours.addElement(n2);
		return n1;
	}
}
