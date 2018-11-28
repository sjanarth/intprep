package com.intprep.trees.problems;

import com.intprep.trees.problems.BSTToLinkedList.Node;

public class IsBinarySearchTree2 
{
	private static final String DELIM = ",";
	
    private static class Node {
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
		Node root = new Node(50);
		Node left = new Node(40);
		left.left = new Node(30);
		left.right = new Node(45);
		root.left = left;
		Node right = new Node(60);
		right.left = new Node(55);
		right.right = new Node(70);
		root.right = right;
		showSampleTree(root);
		return root;
	}
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println("IsBinarySearchTree: "+isBST(root));
	}
	
	private static boolean isBST (Node root) {
		if (root == null)
			return true;
		String inOrder = traverseInOrder (root);
		String[] splits = inOrder.split(DELIM);
		int prev = Integer.parseInt(splits[0]);
		for (int i = 1; i < splits.length; i++)	{
			int curr = Integer.parseInt(splits[i]);
			if (prev > curr) {
				return false;
			}
			prev = curr;
		}
		return true;
	}
}