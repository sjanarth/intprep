package com.intprep.trees.problems;

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
    	StringBuilder sba = new StringBuilder();
    	if (findPathToNode(root, a, sba))	{
    		aPath = parseInts (sba.toString());
    	}
    	int[] bPath = new int[0];
    	StringBuilder sbb = new StringBuilder();
    	if (findPathToNode(root, b, sbb))	{
    		bPath = parseInts (sbb.toString());
    	}
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
    	//System.out.println("parseInts called with "+s);
    	String[] splits = s.split(",");
    	int[] ints = new int[splits.length];
    	for (int i = 0; i < splits.length; i++)	
    		ints[i] = Integer.parseInt(splits[i]);
    	return ints;
    }    
}