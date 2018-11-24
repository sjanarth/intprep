package com.intprep.trees.problems;

public class IsBinarySearchTree 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
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
	
	private static boolean isBST (Node root) {
		return isBSTHelper (root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
    private static void traverseInOrder (Node node, StringBuffer sb) {
    	if (node.left != null)	
    		traverseInOrder(node.left, sb);
    	if (sb.length() > 0)
    		sb.append(","+node.data);
    	else
    		sb.append(node.data);
    	if (node.right != null)	
    		traverseInOrder(node.right, sb);
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
		return root;
	}
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		StringBuffer sb = new StringBuffer ();
		traverseInOrder (root, sb);
		System.out.println("InOrder: "+sb.toString());
		System.out.println("IsBinarySearchTree: "+isBST(root));
	}
}
