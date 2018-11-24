package com.intprep.trees.problems;

public class IsBinarySearchTree2 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }

	private static boolean isBST (Node root) {
		if (root == null)
			return true;
		StringBuffer sb = new StringBuffer ();
		traverseInOrder (root, sb);
		String[] splits = sb.toString().split(",");
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
		right.left = new Node(55);
		right.right = new Node(70);
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
