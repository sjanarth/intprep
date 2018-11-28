package com.intprep.trees.problems;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ClosestLeaf
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

	protected static Node buildSampleTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n8 = new Node(8); 	n5.right = n8;
		Node n10 = new Node(10); n8.right = n10;
		Node n6 = new Node(6);	n4.left = n6;
//		Node n7 = new Node(7);	n3.right = n7;
		Node n9 = new Node(9);	n6.left = n9;
		showSampleTree(root);
		return root;
	}	
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		findClosestLeaf (root, new Node(2));
    }

	private static void findClosestLeaf (Node root, Node start) {
		Set<String> allPaths = getAllPathsToLeaves(root);
		String pathWith = findClosestLeafThroughNode (allPaths, start);
		String pathWithout = findClosestLeafNotThroughNode (allPaths, start);
		//System.out.println("Closest-Path-1: "+pathWith);
		//System.out.println("Closest-Path-2: "+pathWithout);
		int indStart = pathWith.indexOf(String.valueOf(start.data));
		String startToRoot = pathWith.substring(0, indStart+1);
		StringBuilder pathCombined = new StringBuilder(startToRoot);
		pathCombined = pathCombined.reverse();
		int indLCA = findLCA (pathWith, pathWithout);
		String pathAfterLCA = pathWithout.substring(indLCA+2); 
		if (pathAfterLCA.length() > 0) {
			pathCombined.append(",");
			pathCombined.append(pathAfterLCA);
		}
		pathWithout = pathCombined.toString();
		String closestLeaf = pathWith.length() < pathWithout.length() ? pathWith : pathWithout;
		System.out.println("Closest-Leaf of "+start.data+": "+closestLeaf);
	}
	
    private static Set<String> getAllPathsToLeaves (Node root) {
    	Set<String> paths = new HashSet<String>();
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
    				paths.add(getPath(dq.iterator()));
    			}
				dq.removeLast();
				processed.add(curr);
				curr = dq.isEmpty() ? null : dq.getLast();
    		}
    	}
    	return paths;
    }
    
	private static String getPath (Iterator<Node> it) {
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			if (sb.length() > 0) sb.append(DELIM);
			sb.append(it.next().data);
		}
		return sb.toString();
	}
    
    private static String findClosestLeafThroughNode (Set<String> allPaths, Node node) {
    	String shortestPath = null;
    	for (String path : allPaths) {
    		if (path.contains(String.valueOf(node.data)))	{
    			if (shortestPath == null || shortestPath.length() > path.length())	{
    				shortestPath = path;
    			}
    		}
    	}
    	return shortestPath;
    }
    
    private static String findClosestLeafNotThroughNode (Set<String> allPaths, Node node) {
    	String shortestPath = null;
    	for (String path : allPaths) {
    		if (!path.contains(String.valueOf(node.data)))	{
    			if (shortestPath == null || shortestPath.length() > path.length())	{
    				shortestPath = path;
    			}
    		}
    	}
    	return shortestPath;
    }
    
    private static int findLCA (String path1, String path2) {
    	if (path1 == null || path2 == null)
    		return -1;
    	String[] path1Arr = path1.split(DELIM);
    	String[] path2Arr = path2.split(DELIM);
    	int i = 0;
    	while (i < path1Arr.length && i < path2Arr.length && path1Arr[i] == path2Arr[i]) {
    		i++;
    	}
    	return i;
    }
}