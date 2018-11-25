package com.intprep.trees.problems;

public class IsSubTree2 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
    private static void traverseInOrder (Node node, StringBuilder sb) {
    	if (node.left != null)	
    		traverseInOrder(node.left, sb);
    	if (sb.length() > 0)
    		sb.append(","+node.data);
    	else
    		sb.append(node.data);
    	if (node.right != null)	
    		traverseInOrder(node.right, sb);
    }
    
    private static void traversePreOrder (Node node, StringBuilder sb) {
    	if (sb.length() > 0)
    		sb.append(","+node.data);
    	else
    		sb.append(node.data);
    	if (node.left != null)	
    		traversePreOrder(node.left, sb);
    	if (node.right != null)	
    		traversePreOrder(node.right, sb);
    }

    /*
     * We cannot rebuild a tree from from its in, pre or post order traversals.
     * However, if we knew the inorder and the pre or post orders, one can rebuild the tree.
     * Therefore, we take both the inorder and the preorder traversals below. 
     */
    private static boolean isSubTree (Node root, Node root2) {
    	StringBuilder rootInOrder = new StringBuilder();
    	traverseInOrder (root, rootInOrder);
    	System.out.println("InOrder(root): "+rootInOrder.toString());
    	StringBuilder rootPreOrder = new StringBuilder();
    	traversePreOrder (root, rootPreOrder);
    	System.out.println("PreOrder(root): "+rootPreOrder.toString());
    	StringBuilder root2InOrder = new StringBuilder();
    	traverseInOrder (root2, root2InOrder);
    	System.out.println("InOrder(root2): "+root2InOrder.toString());
    	StringBuilder root2PreOrder = new StringBuilder();
    	traversePreOrder (root2, root2PreOrder);
    	System.out.println("PreOrder(root2): "+root2PreOrder.toString());
    	return (rootInOrder.indexOf(root2InOrder.toString()) > -1 &&
    			rootPreOrder.indexOf(root2PreOrder.toString()) > -1);
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
		return root;
	}
	
	private static Node buildSampleTree2()	{
		Node left = new Node(40);
		left.left = new Node(30);
		left.right = new Node(45);
		return left;
	}

	public static void main (String[] args) {
		Node root = buildSampleTree();
		Node root2 = buildSampleTree2();
		System.out.println("IsSubTree: "+isSubTree(root, root2));
	}
}
