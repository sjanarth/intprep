package com.intprep.trees.problems;

import com.intprep.trees.problems.BSTToLinkedList.Node;

public class ListAllPathsInTree2 
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
	
    private static void printAllPaths (Node root) {
    	System.out.println("Showing paths to all leaf nodes");
    	int[] arr = new int[1000];
    	printAllPaths (root, arr, 0);
    }

    private static void printAllPaths (Node node, int[] arr, int len) {
    	arr[len++] = node.data;
    	if (node.left == null && node.right == null)	{
    		printArray(arr, len);
    	} else {
    		if (node.left != null) printAllPaths (node.left, arr, len);
    		if (node.right != null) printAllPaths (node.right, arr, len);
    	}
    }

	private static void printArray (int[] arr, int len)	{
    	for (int i = 0; i < len; i++)
    		System.out.print(arr[i]+DELIM);
    	System.out.println();
    }
}
