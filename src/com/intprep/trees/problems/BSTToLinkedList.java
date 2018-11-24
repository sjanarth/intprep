package com.intprep.trees.problems;

import java.util.Iterator;
import java.util.Stack;

public class BSTToLinkedList 
{
    private static class Node {
        int data;
        Node left;
        Node right;
        public Node (int d)	{ data = d; }
    }
    
    private static class InOrderIterator implements Iterator<Node>
    {
    	public InOrderIterator(Node root) {
    		stack = new Stack<Node>();    		
    		pushLeft(root);
    	}
    	
    	@Override
    	public boolean hasNext() {
    		return !stack.isEmpty();
    	}
    	
    	@Override
    	public Node next() {
    		if (!hasNext())
    			return null;
    		Node top = stack.pop();
    		pushLeft(top.right);
    		return top;
    	}
    	
    	protected void pushLeft (Node node)	{
    		Node curr = node;
    		while (curr != null) {
    			stack.push(curr);
    			curr = curr.left;
    		}
    	}
    	
    	protected Stack<Node> stack = null;
    }
    

    private static void bstToLinkList (Node root) {
    	Iterator<Node> it = new InOrderIterator(root);
    	Node prev = it.next();
    	while (it.hasNext()) {
    		Node curr = it.next();
    		curr.left = prev;
			prev.right = curr; 
//    		System.out.print(prev.data+" => "+curr.data);
    		prev = curr;
    	}
    }
    
    private static void printLinkedList (Node head) {
    	//System.out.println();
    	System.out.print("Left to right: ");
    	Node curr = head;
    	while (curr.left != null)	{
    		curr = curr.left;
    	}
    	while (curr != null)	{
    		System.out.print(curr.data+" ");
    		curr = curr.right;
    	}
    	System.out.println();
    	System.out.print("Right to left: ");
    	curr = head;
    	while (curr.right != null)	{
    		curr = curr.right;
    	}
    	while (curr != null)	{
    		System.out.print(curr.data+" ");
    		curr = curr.left;
    	}
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
	
	public static void main (String[] args) {
		Node root = buildSampleTree();
		StringBuffer sb = new StringBuffer ();
		traverseInOrder (root, sb);
		System.out.println("InOrder: "+sb.toString());
		bstToLinkList(root);
		printLinkedList(root);
	}
}
