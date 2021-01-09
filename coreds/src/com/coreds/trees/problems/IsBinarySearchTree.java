package com.coreds.trees.problems;

public class IsBinarySearchTree extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new IsBinarySearchTree().executeAllTestCases();
	}
	
	@Override
	protected Node buildCustomTree()	{
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
	
	@Override
	public void mainLogic (Node root) {
		System.out.println("IsBinarySearchTree: "+isBST(root));
	}
    
	private static boolean isBST (Node root) {
		// Since our tree stores integers, we have to go beyond the integer range, hence the use of longs
		// According to wikipedia, a BST cannot have duplicate values.
		return isBST (root, Long.MIN_VALUE, Long.MAX_VALUE); 
	}

	private static boolean isBST (Node node, Long min, Long max) {
		if (node == null)	return true;
		return (min < node.data &&
				max > node.data &&
				isBST (node.left, min, new Long(node.data)) &&
				isBST (node.right, new Long(node.data), max));
    }
}