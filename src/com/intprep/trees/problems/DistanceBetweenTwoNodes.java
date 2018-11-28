package com.intprep.trees.problems;

public class DistanceBetweenTwoNodes
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
    private static boolean findPathToNode (Node root, Node node, StringBuilder sb)	{
		sb.append(root.data+",");
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
    	System.out.println("parseInts called with "+s);
    	String[] splits = s.split(",");
    	int[] ints = new int[splits.length];
    	for (int i = 0; i < splits.length; i++)	
    		ints[i] = Integer.parseInt(splits[i]);
    	return ints;
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
    	int i = 0;
    	while (i < aPath.length && i < bPath.length && aPath[i] == bPath[i]) {
    		i++;
    	}
    	int dist = aPath.length + bPath.length - 2 * i;
    	System.out.println(dist);
    }
    
	private static Node buildSampleTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n6 = new Node(6);	n3.left = n6;
		Node n7 = new Node(7);	n3.right = n7;
		Node n8 = new Node(8);	n6.left = n8;
		Node n9 = new Node(9);	n8.right = n9;
		return root;
	}
    
	public static void main (String[] args) {
		Node root = buildSampleTree();
		distanceBetweenNodes (root, new Node(4), new Node(7));
    }

}
