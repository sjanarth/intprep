package com.intprep.trees.problems;

public class ListAllPaths2 extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new ListAllPaths2().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root) {
		printAllPaths(root);
    }
	
    private static void printAllPaths (Node root) {
    	System.out.println("Showing paths to all leaf nodes");
    	int[] arr = new int[1000];
    	printAllPaths (root, arr, 0);
    }

    private static void printAllPaths (Node node, int[] arr, int len) {
    	if (node == null) return;
    	arr[len++] = node.data;
    	if (node.left == null && node.right == null)	{
    		printArray(arr, len);
    	} else {
    		if (node.left != null) printAllPaths (node.left, arr, len);
    		if (node.right != null) printAllPaths (node.right, arr, len);
    	}
    }

	private static void printArray (int[] arr, int len)	{
    	if (arr.length > 0) System.out.print(arr[0]);
		for (int i = 1; i < len; i++)
    		System.out.print(DELIM+arr[i]);
    	System.out.println();
    }
}