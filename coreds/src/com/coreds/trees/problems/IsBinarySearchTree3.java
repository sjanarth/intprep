package com.coreds.trees.problems;

public class IsBinarySearchTree3  extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new IsBinarySearchTree3().executeAllTestCases();
	}

	@Override
	protected Node buildCustomTree()	{
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
	
	@Override
	public void mainLogic (Node root) {
		System.out.println("IsBinarySearchTree3: "+isBST(root));
	}
	
	private boolean isBST (Node root) {
		if (root == null)
			return true;
		if (!isBST(root.left) || !isBST(root.right))
			return false;
		if (root.left != null && root.data < root.left.data)
			return false;
		if (root.right != null && root.data > root.right.data)
			return false;
		return true;
	}
}
