package com.intprep.trees.problems;

import com.intprep.trees.problems.BSTToLinkedList.Node;

public class LowestCommonAncestor 
{
	protected static final String DELIM = ",";
	
	protected static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
	protected static String traversePreOrder(Node node)	{
		StringBuilder sb = new StringBuilder();
		sb.append(node.data);
		if (node.left != null)
			sb.append(DELIM+traversePreOrder(node.left));
		if (node.right != null)
			sb.append(DELIM+traversePreOrder(node.right));
		return sb.toString();
	}
    
	protected static String traverseInOrder(Node node) {
		StringBuilder sb = new StringBuilder();
		if (node.left != null)
			sb.append(traverseInOrder(node.left));
		if (sb.length() > 0) sb.append(DELIM);
		sb.append(node.data);
		if (node.right != null)
			sb.append(DELIM+traverseInOrder(node.right));
		return sb.toString();
	}
	
	protected static void showSampleTree (Node root) {
		System.out.println("InOrder: "+traverseInOrder(root));
		System.out.println("PreOrder: "+traversePreOrder(root));
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
		showSampleTree(root);
		return root;
	}
    
	public static void main (String[] args) {
		Node root = buildSampleTree();
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
    	int i = 0;
    	while (i < aPath.length && i < bPath.length && aPath[i] == bPath[i]) {
    		i++;
    	}
    	int lca = (i < aPath.length ? aPath[i-1] : bPath[i-1]);
    	System.out.println("LCA ("+a.data+","+b.data+"): "+lca);
    	return lca;
    }
	
    private static boolean findPathToNode (Node root, Node node, StringBuilder sb)	{
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
