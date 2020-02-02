package com.intprep.trees.problems;

import java.util.ArrayList;
import java.util.List;

public class DeepestLeaf extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new DeepestLeaf().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root) {
		System.out.println("Deepest Path: "+getDeepestPath(root));
    }
	
	private static String getDeepestPath(Node node) {
		List<String> allPaths = new ArrayList<String>();
		findAllLeafPaths (node, allPaths, "");
		String deepestPath = null;
		int deepestPathLen = Integer.MIN_VALUE;
		for (String path : allPaths) {
			if (deepestPath == null)	{
				deepestPath = path; 
				deepestPathLen = path.split(DELIM).length;
				continue;
			}
			int pathLen = path.split(DELIM).length;
			if (deepestPathLen < pathLen)	{
				deepestPath = path;
				deepestPathLen = pathLen;
			}
		}
		return deepestPath; // == null ? null : deepestPath.substring(deepestPath.length()-1);
	}
	
	private static void findAllLeafPaths (Node node, List<String> allPaths, String curPath)	{
		if (node == null) return;
		String curPath2 = curPath.isEmpty() ? 
							String.valueOf(node.data) : 
							curPath + DELIM + node.data;	
		if (node.left == null && node.right == null) {
			allPaths.add(curPath2);
			return;
		}
		findAllLeafPaths (node.left, allPaths, curPath2);
		findAllLeafPaths (node.right, allPaths, curPath2);
	}
	
	private static String getDeepestPath2(Node node) {
		if(node == null) return "";
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		String sLeft = getDeepestPath2(node.left);
		String sRight = getDeepestPath2(node.right);
		String[] aLeft = (sLeft.isEmpty() ? new String[0] : sLeft.split(DELIM, -1));
		String[] aRight = (sRight.isEmpty() ? new String[0] : sRight.split(DELIM, -1));
		//System.out.println("node="+node.data+", aLeft="+aLeft.length+",aRight="+aRight.length);
		String[] aLonger = (aLeft.length > aRight.length ? aLeft : aRight);
		if (aLeft.length == 0) aLonger = aRight;
		if (aRight.length == 0) aLonger = aLeft;
		for (int i = 0; i < aLonger.length; i++)	{
			if (!aLonger[i].equals(""))
				sb.append(","+aLonger[i]);
		}
		return sb.toString();
	}
}