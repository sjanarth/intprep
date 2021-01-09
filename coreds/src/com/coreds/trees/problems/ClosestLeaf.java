package com.coreds.trees.problems;

import java.util.*;

public class ClosestLeaf extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new ClosestLeaf().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root) {
		findClosestLeaf (root, new Node(2));
    }

	private static void findClosestLeaf (Node root, Node start) {
		if(root == null || start == null) return;
		Set<String> allPaths = getAllPathsToLeaves(root);
		String pathWith = findClosestLeafThroughNode (allPaths, start);
		String pathWithout = findClosestLeafNotThroughNode (allPaths, start);
		System.out.println("pathWith=["+pathWith+"]");
		System.out.println("pathWithout=["+pathWithout+"]");
		String pathDown = getPathFromStart(pathWith, start);
		String pathThroughLCA = getPathThroughLCA(pathWith, pathWithout, start);
		System.out.println("pathDown=["+pathDown+"]");
		System.out.println("pathThroughLCA=["+pathThroughLCA+"]");
		String closestLeaf = pathDown.length() < pathThroughLCA.length() ? pathDown : pathThroughLCA;
		if (pathDown.isEmpty())
			closestLeaf = pathThroughLCA;
		if (pathThroughLCA.isEmpty())
			closestLeaf = pathDown;
		System.out.println("Closest-Leaf of "+start.data+": "+closestLeaf);
	}
	
    private static Set<String> getAllPathsToLeaves (Node root) {
    	Set<String> paths = new HashSet<String>();
    	Deque<Node> dq = new LinkedList<Node>();
    	Set<Node> processed = new HashSet<Node>();
    	Node curr = root;
    	dq.addFirst(curr);
    	while (curr != null)	{
    		if (curr.left != null && !processed.contains(curr.left)) {
				dq.addLast(curr.left);
				curr = curr.left;
    		} else if (curr.right != null && !processed.contains(curr.right)) {
    			dq.addLast(curr.right);
    			curr = curr.right;
    		} else {
    			if (curr.left == null && curr.right == null)	{
    				paths.add(getPath(dq.iterator()));
    			}
				dq.removeLast();
				processed.add(curr);
				curr = dq.isEmpty() ? null : dq.getLast();
    		}
    	}
    	return paths;
    }
    
	private static String getPath (Iterator<Node> it) {
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			if (sb.length() > 0) sb.append(DELIM);
			sb.append(it.next().data);
		}
		return sb.toString();
	}
    
    private static String findClosestLeafThroughNode (Set<String> allPaths, Node node) {
    	String shortestPath = null;
    	for (String path : allPaths) {
    		if (path.contains(String.valueOf(node.data)))	{
    			if (shortestPath == null || shortestPath.length() > path.length())	{
    				shortestPath = path;
    			}
    		}
    	}
    	return shortestPath;
    }
    
    private static String findClosestLeafNotThroughNode (Set<String> allPaths, Node node) {
    	String shortestPath = null;
    	for (String path : allPaths) {
    		if (!path.contains(String.valueOf(node.data)))	{
    			if (shortestPath == null || shortestPath.length() > path.length())	{
    				shortestPath = path;
    			}
    		}
    	}
    	return shortestPath;
    }

    private static String getPathFromStart (String pathWith, Node start) {
    	if (pathWith == null) return "";
		int indStart = pathWith.indexOf(String.valueOf(start.data));
		String fromStart = pathWith.substring(indStart);
		return fromStart;
    }
    
    private static String getPathThroughLCA (String pathWith, String pathWithout, Node start) {
    	if (pathWith == null || pathWithout == null) return "";
    	int indStart = pathWith.indexOf(String.valueOf(start.data));
		String rootToStart = pathWith.substring(0, indStart+1);
		StringBuilder pathCombined = new StringBuilder(rootToStart);
		pathCombined = pathCombined.reverse();
		int indLCA = findLCA (pathWith, pathWithout);
		String pathAfterLCA = pathWithout.substring(indLCA+2);
		if (pathAfterLCA.length() > 0) {
			pathCombined.append(",");
			pathCombined.append(pathAfterLCA);
		}
		return pathCombined.toString();
    }
    
    private static int findLCA (String path1, String path2) {
    	if (path1 == null || path2 == null)
    		return -1;
    	String[] path1Arr = path1.split(DELIM);
    	String[] path2Arr = path2.split(DELIM);
    	int i = 0;
    	while (i < path1Arr.length && i < path2Arr.length && path1Arr[i].equals(path2Arr[i])) {
    		i++;
    	}
    	return i;
    }
}