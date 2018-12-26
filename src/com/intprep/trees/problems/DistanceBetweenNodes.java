package com.intprep.trees.problems;

public class DistanceBetweenNodes extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new DistanceBetweenNodes().executeAllTestCases();
	}
	
	@Override
	public void mainLogic (Node root) {
		distanceBetweenNodes (root, new Node(4), new Node(7));
    }
    
    private static void distanceBetweenNodes (Node root, Node a, Node b)	{
    	int[] aPath = new int[0];
    	StringBuilder sba = new StringBuilder();
    	if (findPathToNode(root, a, sba))	{
    		aPath = parseInts (sba.toString());
    	}
    	int[] bPath = new int[0];
    	StringBuilder sbb = new StringBuilder();
    	if (findPathToNode(root, b, sbb))	{
    		bPath = parseInts (sbb.toString());
    	}
    	int dist = 0;
    	if (aPath.length > 0 && bPath.length > 0)	{
	    	int i = 0;
	    	while (i < aPath.length && i < bPath.length && aPath[i] == bPath[i]) {
	    		i++;
	    	}
	    	dist = aPath.length + bPath.length - 2 * i;
    	}
    	System.out.println("Distance between "+a.data+" and "+b.data+" is "+dist);
    }    
    
    private static boolean findPathToNode (Node root, Node node, StringBuilder sb)	{
    	if (root == null || node == null) return false;
		sb.append(root.data+DELIM);
    	if (root.data == node.data)	{	
			return true;
		}
		if (root.left != null)	{
			StringBuilder sb2 = new StringBuilder();
			if(findPathToNode(root.left, node, sb2))	{
				sb.append(sb2.toString());
				return true;
			}
		}
		if (root.right != null)	{
			StringBuilder sb2 = new StringBuilder();
			if(findPathToNode(root.right, node, sb2))	{
				sb.append(sb2.toString());
				return true;
			}
		}
		return false;
    }
    
    private static int[] parseInts (String s) {
//    	System.out.println("parseInts called with "+s);
    	String[] splits = s.split(DELIM);
    	int[] ints = new int[splits.length];
    	for (int i = 0; i < splits.length; i++)	
    		ints[i] = Integer.parseInt(splits[i]);
    	return ints;
    }
}