package com.intprep.trees.problems;

import java.util.ArrayList;
import java.util.List;

public class ListAllPaths3  extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new ListAllPaths3().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root) {
		List<String> allPaths = new ArrayList<String>();
		findAllPaths(allPaths, root, "");
    	System.out.println("Showing paths to all leaf nodes");
    	for (String path : allPaths)	
    		System.out.println(path);
    }
	
    private static void findAllPaths (List<String> allPaths, Node root, String curPath) {
    	if (root == null) return;
    	String curPath2 = curPath + " => " + root.data;
    	if (root.left == null && root.right == null)	{
    		allPaths.add(curPath2);
    		return;
    	}
    	findAllPaths(allPaths, root.left, curPath2);
    	findAllPaths(allPaths, root.right, curPath2);
    }
}
