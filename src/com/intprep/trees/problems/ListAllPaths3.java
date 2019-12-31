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
		findAllPaths(allPaths, root, new StringBuilder());
    	System.out.println("Showing paths to all leaf nodes");
    	for (String path : allPaths)	
    		System.out.println(path);
    }
	
    private static void findAllPaths (List<String> allPaths, Node root, StringBuilder pathSoFar) {
    	if (root != null)	{
    		StringBuilder sb = new StringBuilder(pathSoFar+" => "+root.data);
    		if (root.left == null && root.right == null)	{
    			allPaths.add(sb.toString());
    			return;
    		} 
    		else {
    			if (root.left != null)	findAllPaths (allPaths, root.left, sb);
    			if (root.right != null) findAllPaths (allPaths, root.right, sb);
    		}
    	}
    }
}
