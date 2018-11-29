package com.intprep.trees.problems;

public class FlipBinaryTree extends AbstractTreeProblem 
{
	public static void main(String[] args) {
		new FlipBinaryTree().executeAllTestCases();
	}
	
	@Override
	protected void mainLogic(Node root) {
		Node flipped = flipTree(root);
		System.out.println("Showing the fliped tree");
		showTree(flipped);
	}
	
	private Node flipTree(Node root) {
		if (root == null) return null;
		Node node = new AbstractTreeProblem.Node(root.data);
		if (root.left != null)	{
			node.right = flipTree(root.left);
		}
		if (root.right != null)	{
			node.left = flipTree(root.right);
		}
		return node;
	}
}
