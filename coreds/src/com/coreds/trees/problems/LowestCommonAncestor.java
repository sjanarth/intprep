package com.coreds.trees.problems;

public class LowestCommonAncestor extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new LowestCommonAncestor().executeAllTestCases();
	}

	@Override
	public void mainLogic (Node root)	{
		lca(root, new Node(4), new Node(5));
    }

    private static int lca(Node root, Node a, Node b)	{
    	//printInOrder (root);
    	int[] aPath = new int[0];
    	String path = findPathToNode (root, a);
    	if (path != null)
    		aPath = parseInts (path);
    	int[] bPath = new int[0];
    	path = findPathToNode(root, b);
    	if (path != null)	
    		bPath = parseInts (path);
    	int lca = -1;
    	if (aPath.length > 0 && bPath.length > 0)	{
	    	int i = 0;
	    	while (i < aPath.length && i < bPath.length && aPath[i] == bPath[i]) {
	    		i++;
	    	}
	    	lca = (i < aPath.length ? aPath[i-1] : bPath[i-1]);
    	}
    	System.out.println("LCA ("+a.data+","+b.data+"): "+lca);
    	return lca;
    }
    
    private static String findPathToNode (Node root, Node node)	{
    	if (root == null || node == null) return null;
    	if (root.data == node.data) return String.valueOf(root.data)+DELIM;
    	String path = findPathToNode(root.left, node);
    	if (path != null)	
    		return root.data + DELIM + path;
    	path = findPathToNode(root.right, node);
    	if (path != null)	
    		return root.data + DELIM + path;
    	return null;
    }
    
    private static int[] parseInts (String s) {
    	//System.out.println("parseInts called with "+s);
    	String[] splits = s.split(",");
    	int[] ints = new int[splits.length];
    	for (int i = 0; i < splits.length; i++)	
    		ints[i] = Integer.parseInt(splits[i]);
    	return ints;
    }    
}