package com.intprep.trees.problems;

public class DeepestLeaf 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
	private static Node buildSampleTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n8 = new Node(8); 	n5.right = n8;
		Node n10 = new Node(10); n8.right = n10;
		Node n6 = new Node(6);	n3.left = n6;
		Node n7 = new Node(7);	n3.right = n7;
		Node n9 = new Node(9);	n6.left = n9;
		return root;
	}

	public static String traverseInOrder(Node node) {
		StringBuilder sb = new StringBuilder();
		if (node.left != null)
			sb.append(traverseInOrder(node.left));
		sb.append(node.data+",");
		if (node.right != null)
			sb.append(traverseInOrder(node.right));
		return sb.toString();
	}
	
	private static String getDeepestPath(Node node) {
		if(node == null)
			return "";
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		String[] aLeft = getDeepestPath(node.left).split(",", -1);
		String[] aRight = getDeepestPath(node.right).split(",", -1);
		String[] aLonger = (aLeft.length > aRight.length ? aLeft : aRight);
		for (int i = 0; i < aLonger.length; i++)	{
			sb.append(","+aLonger[i]);
		}
		return sb.toString();
	}
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println("InOrder: "+traverseInOrder(root));
		System.out.println("Deepest Path: "+getDeepestPath(root));
    }
}