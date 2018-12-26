package com.intprep.trees.problems;

public class IsBinarySearchTree2 extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new IsBinarySearchTree2().executeAllTestCases();
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
		System.out.println("IsBinarySearchTree2: "+isBST(root));
	}
	
	private boolean isBST (Node root) {
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