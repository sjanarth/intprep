package com.intprep.trees.problems;

public class LongestLeafToLeafPath extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new LongestLeafToLeafPath().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root)	{
		System.out.println("Diameter: "+getDiameter(root));
	}
	
	private int getDiameter (Node node) {
		if (node == null)
			return 0;
		int lHeight = getHeight(node.left);
		int rHeight = getHeight(node.right);
		int lDiameter = getDiameter(node.left);
		int rDiameter = getDiameter(node.right);
		return Math.max(lHeight+rHeight+1, Math.max(lDiameter,  rDiameter));
	}
	
	private int getHeight (Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
}