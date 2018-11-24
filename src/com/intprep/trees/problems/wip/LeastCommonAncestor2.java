package com.intprep.trees.problems.wip;

public class LeastCommonAncestor2 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }

    private static void traverseInOrder (Node node, StringBuffer sb) {
    	if (node.left != null)	
    		traverseInOrder(node.left, sb);
    	if (sb.length() > 0)
    		sb.append(","+node.data);
    	else
    		sb.append(node.data);
    	if (node.right != null)	
    		traverseInOrder(node.right, sb);
    }
    
    private static String[] findPathsToNodes (Node root, Node[] nodes)	{
    	StringBuffer sb = new StringBuffer();
    	traverseInOrder (root, sb);
    	System.out.println("In oder: "+sb.toString());
    	String[] paths = new String[nodes.length];
    	for (int i = 0; i < nodes.length; i++) {
    		int index = sb.indexOf(String.valueOf(nodes[i].data));
    		if (index > -1)	
    			paths[i] = sb.substring(0, index);
    		else
    			paths[i] = null;
    	}
    	return paths;
    }
        
    private static int lca(Node root, Node a, Node b)	{
    	String[] paths = findPathsToNodes (root, new Node[] {a,b});
//    	System.out.println("paths[0]: "+paths[0]);
//    	System.out.println("paths[1]: "+paths[1]);
    	String longerPath = (paths[0].length() >= paths[1].length() ? paths[0] : paths[1]);
    	String[] splits = longerPath.split(",");
    	return Integer.parseInt(splits[splits.length-1]);
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
		return root;
	}
    
	public static void main (String[] args) {
		Node root = buildSampleTree();
		System.out.println();
		System.out.println(lca(root, new Node(8), new Node(2)));
    }
}
