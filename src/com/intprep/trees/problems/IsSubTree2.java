package com.intprep.trees.problems;

public class IsSubTree2 
{
	protected static final String DELIM = ",";
	
    private static class Node {
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
		Node root = new Node(50);
		Node left = new Node(40);
		left.left = new Node(30);
		left.right = new Node(45);
		root.left = left;
		Node right = new Node(60);
		right.left = new Node(55);
		right.right = new Node(70);
		root.right = right;
		showSampleTree(root);
		return root;
	}
	
	private static Node buildSampleTree2()	{
		Node left = new Node(40);
		left.left = new Node(30);
		left.right = new Node(45);
		showSampleTree(left);
		return left;
	}

	public static void main (String[] args) {
		Node root = buildSampleTree();
		Node root2 = buildSampleTree2();
		System.out.println("IsSubTree: "+isSubTree(root, root2));
	}

    /*
     * We cannot rebuild a tree from from its in, pre or post order traversals.
     * However, if we knew the inorder and the pre or post orders, one can rebuild the tree.
     * Therefore, we take both the inorder and the preorder traversals below. 
     */
    private static boolean isSubTree (Node root, Node root2) {
    	String rootInOrder = traverseInOrder (root); 
    	String rootPreOrder = traversePreOrder (root);
    	String root2InOrder = traverseInOrder (root2);
    	String root2PreOrder = traversePreOrder (root2);
    	return (rootInOrder.indexOf(root2InOrder.toString()) > -1 &&
    			rootPreOrder.indexOf(root2PreOrder.toString()) > -1);
    }
}
