package com.intprep.trees.problems;

public class IsBinarySearchTree 
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
		right.left = new Node(70);
		right.right = new Node(55);
		root.right = right;
		showSampleTree(root);
		return root;
	}
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println("IsBinarySearchTree: "+isBST(root));
	}
    
	private static boolean isBST (Node root) {
		return isBSTHelper (root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}

	private static boolean isBSTHelper (Node node, Integer min, Integer max) {
		if (node == null)	{
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		if (node.left != null)	{
			if (!isBSTHelper(node.left, min, node.data-1))
				return false;
		}
		if (node.right != null)	{
			if (!isBSTHelper(node.right, node.data+1, max))
				return false;
		}
		return true;
    }
}