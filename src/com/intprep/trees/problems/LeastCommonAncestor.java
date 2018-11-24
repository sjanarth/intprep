package com.intprep.trees.problems;

public class LeastCommonAncestor 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
      
    private static boolean findPathToNode (Node root, Node node, StringBuffer sb)	{
		sb.append(root.data+",");
    	if (root.data == node.data)	{	
			return true;
		}
		if (root.left != null)	{
			StringBuffer sb2 = new StringBuffer();
			if(findPathToNode(root.left, node, sb2))	{
				sb.append(sb2.toString());
				return true;
			}
		}
		if (root.right != null)	{
			StringBuffer sb2 = new StringBuffer();
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
    
    private static void printInOrder (Node node) {
    	if (node.left != null)
    		printInOrder (node.left);
    	System.out.print(" "+node.data);
    	if (node.right != null)
    		printInOrder (node.right);
    }
    
    private static int lca(Node root, Node a, Node b)	{
    	//printInOrder (root);
    	int[] aPath = new int[0];
    	StringBuffer sba = new StringBuffer();
    	if (findPathToNode(root, a, sba))	{
    		aPath = parseInts (sba.toString());
    	}
    	int[] bPath = new int[0];
    	StringBuffer sbb = new StringBuffer();
    	if (findPathToNode(root, b, sbb))	{
    		bPath = parseInts (sbb.toString());
    	}
    	int i = 0;
    	while (i < aPath.length && i < bPath.length && aPath[i] == bPath[i]) {
    		i++;
    	}
    	return (i < aPath.length ? aPath[i] : bPath[i]);
    }
    
	private static Node buildSampleTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		/*Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n6 = new Node(6);	n3.left = n6;
		Node n7 = new Node(7);	n3.right = n7;
		Node n8 = new Node(8);	n6.left = n8;
		*/
		return root;
	}
    
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println();
		System.out.println(lca(root, new Node(2), new Node(1)));
    }
}