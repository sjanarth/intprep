package com.intprep.trees.problems;

public class IsSubTree 
{
	protected static final String DELIM = ",";
	
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
	
	private static Node buildSampleTree2()	{
		Node left = new Node(40);
		left.left = new Node(30);
		left.right = new Node(45);
		showSampleTree(left);
		return left;
	}

	public static void main (String[] args) {
		Node root = buildSampleTree();
		Node root2 = buildSampleTree2();
		System.out.println("IsSubTree: "+isSubTree(root, root2));
	}
    
    private static boolean areIdentical (Node root, Node root2) {
    	if (root2 == null)
    		return true;
    	if (root == null)
    		return false;
    	if (root.data != root2.data)
    		return false;
    	if ((root.left == null) && (root2.left != null))
    		return false;
    	if ((root.right == null) && (root2.right != null))
    		return false;
    	return areIdentical (root.left, root2.left) &&
    			areIdentical (root.right, root2.right);
    }
    
    // For each node in root, check if the subtree at root is identical to root2
    private static boolean isSubTree (Node root, Node root2) {
    	if (areIdentical (root, root2))
    		return true;
    	if (root.left != null)
    		if (isSubTree(root.left, root2))
    			return true;
    	if (root.right != null)
    		if (isSubTree(root.right, root2))
    			return true;
    	return false;
    }
    
}
