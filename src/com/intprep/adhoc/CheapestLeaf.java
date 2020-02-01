package com.intprep.adhoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CheapestLeaf 
{
	private static class Node	{
		String value = null;
		int weight = 0;
		List<Node> children = new ArrayList<Node>();
		Node (String v, int w)	{ value = v; weight = w; }
		Node (String v, int w, Node[] kids) { this(v,w); for (Node k : kids) children.add(k); }
	}
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println("Cheapest leaf = "+findCheapestLeaf(root));
		System.out.println("Cheapest leaf = "+findCheapestLeaf(root, 0));
	}
	
	private static Node buildSampleTree()	{
		Node e = new Node("e", 6);
		Node f = new Node("f", 3);
		Node b = new Node("b", 4, new Node[] {e,f});
		Node g = new Node("g", 7);
		Node c = new Node("c", 9, new Node[] {g});
		Node h = new Node("h", 2);
		Node i = new Node("i", 3);
		Node j = new Node("j", 5);
		Node d = new Node("d", 11, new Node[] {h,i,j});
		Node a = new Node("a", 0, new Node[] {b,c,d});
		return a;
	}
	
	private static String findCheapestLeaf (Node root) {
		Stack<Node> st = new Stack<Node>();
		Map<Node,Integer> costs = new HashMap<Node,Integer>();
		costs.put(root, 0);
		st.push(root);
		while(!st.isEmpty())	{
			Node currNode = st.pop();
			for (Node k : currNode.children)	{
				st.push(k);
				costs.put(k, k.weight+costs.get(currNode));
			}
			if (!currNode.children.isEmpty())	{
				costs.remove(currNode);
			}	
		}
		Node minNode = null;
		int minCost = Integer.MAX_VALUE;
		for (Node k : costs.keySet())	{
			int thisCost = costs.get(k);
			if (thisCost < minCost)	{
				minCost = thisCost;
				minNode = k;
			}
		}
		return "value=["+minNode.value+"], cost=["+minCost+"]";
	}
	
	private static int findCheapestLeaf (Node root, int cost)	{
		if (root.children.isEmpty())	{
			//System.out.println("Cost("+root.value+") = "+cost);
			return cost;
		} else	{
			int minCost = Integer.MAX_VALUE;
			for (Node c : root.children) {
				int thisCost = findCheapestLeaf(c, cost + c.weight);
				if (thisCost < minCost) {
					minCost = thisCost;
				}
			}
			//System.out.println("Cost("+root.value+") = "+minCost);
			return minCost;
		}
	}
}
