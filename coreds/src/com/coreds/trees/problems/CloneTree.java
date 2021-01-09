package com.coreds.trees.problems;

public class CloneTree extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new CloneTree().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root)	{
		Node clone = cloneTree(root);
		System.out.println("Cloned tree: ");
		showTree(clone);
	}
	
	private static Node cloneTree(Node root) {
		if (root == null) return null;
		Node node = new Node(root.data);
		node.left = cloneTree(root.left);
		node.right = cloneTree(root.right);
		return node;
	}
}
