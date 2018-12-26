package com.intprep.trees.problems;

import java.util.Iterator;
import java.util.Stack;

public class BSTToLinkedList extends AbstractTreeProblem
{
	public static void main (String[] args) {
		new BSTToLinkedList().executeAllTestCases();
	}
	
	@Override
	protected  Node buildCustomTree()	{
		Node root = new Node(1);
		Node n2 = new Node(2);	root.left = n2;
		Node n3 = new Node(3);	root.right = n3;
		Node n4 = new Node(4);	n2.left = n4;
		Node n5 = new Node(5);	n2.right = n5;
		Node n8 = new Node(8); 	n5.right = n8;
		Node n10 = new Node(10); n8.right = n10;
		Node n6 = new Node(6);	n4.left = n6;
//		Node n7 = new Node(7);	n3.right = n7;
		Node n9 = new Node(9);	n6.left = n9;
		return root;
	}	

	@Override
	public void mainLogic (Node root)	{
		bstToLinkList(root);
		printLinkedList(root);
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
    	if (head != null)	{
    		Node curr = head;
	    	while (curr.left != null)	{
	    		curr = curr.left;
	    	}
    		System.out.print(curr.data);
    		curr = curr.right;
	    	while (curr != null)	{
	    		System.out.print(DELIM+curr.data);
	    		curr = curr.right;
	    	}
    	}
    	System.out.println();
    	System.out.print("Right to left: ");
    	if (head != null)	{
	    	Node curr = head;
	    	while (curr.right != null)	{
	    		curr = curr.right;
	    	}
    		System.out.print(curr.data);
    		curr = curr.left;
	    	while (curr != null)	{
	    		System.out.print(DELIM+curr.data);
	    		curr = curr.left;
	    	}
    	}
    	System.out.println();
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
}