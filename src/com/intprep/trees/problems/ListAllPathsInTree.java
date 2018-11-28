package com.intprep.trees.problems;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

import com.intprep.trees.problems.BSTToLinkedList.Node;

public class ListAllPathsInTree 
{
	protected static final String DELIM = ",";
	
	protected static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
	protected static String traversePreOrder(Node node)	{
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		if (node.left != null)
			sb.append(DELIM+traversePreOrder(node.left));
		if (node.right != null)
			sb.append(DELIM+traversePreOrder(node.right));
		return sb.toString();
	}
    
	protected static String traverseInOrder(Node node) {
		StringBuilder sb = new StringBuilder();
		if (node.left != null)
			sb.append(traverseInOrder(node.left));
		if (sb.length() > 0) sb.append(DELIM);
		sb.append(node.data);
		if (node.right != null)
			sb.append(DELIM+traverseInOrder(node.right));
		return sb.toString();
	}
	
	protected static void showSampleTree (Node root) {
		System.out.println("InOrder: "+traverseInOrder(root));
		System.out.println("PreOrder: "+traversePreOrder(root));
	}

	private static Node buildSampleTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n6 = new Node(6);	n3.left = n6;
		Node n7 = new Node(7);	n3.right = n7;
		Node n8 = new Node(8);	n6.left = n8;
		showSampleTree(root);
		return root;
	}
    
	public static void main (String[] args) {
		Node root = buildSampleTree();
		printAllPaths(root);
    }
	
    private static void print (Iterator<Node> it) {
    	while (it.hasNext())
    		System.out.print(it.next().data+DELIM);
    	System.out.println();
    }
    
    private static void printAllPaths (Node root) {
    	System.out.println("Showing paths to all leaf nodes");
    	Deque<Node> dq = new LinkedList<Node>();
    	Set<Node> processed = new HashSet<Node>();
    	Node curr = root;
    	dq.addFirst(curr);
    	while (curr != null)	{
    		if (curr.left != null && !processed.contains(curr.left)) {
				dq.addLast(curr.left);
				curr = curr.left;
    		} else if (curr.right != null && !processed.contains(curr.right)) {
    			dq.addLast(curr.right);
    			curr = curr.right;
    		} else {
    			if (curr.left == null && curr.right == null)	{
    				print(dq.iterator());
    			}
				dq.removeLast();
				processed.add(curr);
				curr = dq.isEmpty() ? null : dq.getLast();
    		}
    	}
    }
	
}
