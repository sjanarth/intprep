package com.intprep.trees.problems;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ListAllPaths extends AbstractTreeProblem 
{
	public static void main (String[] args) {
		new ListAllPaths().executeAllTestCases();
	}
	
	@Override
	public void mainLogic(Node root) {
		printAllPaths(root);
    }
	
    private static void printAllPaths (Node root) {
    	System.out.println("Showing paths to leaf nodes");
    	Deque<Node> dq = new LinkedList<Node>();
    	Set<Node> processed = new HashSet<Node>();
    	Node curr = root;
    	dq.addFirst(curr);
    	while (curr != null)	{
    		if (curr.left != null && !processed.contains(curr.left)) {
				dq.addLast(curr.left);
				curr = curr.left;
    		} else if (curr.right != null && !processed.contains(curr.right)) {
    			dq.addLast(curr.right);
    			curr = curr.right;
    		} else {
    			if (curr.left == null && curr.right == null)	{
    				print(dq.iterator());
    			}
				dq.removeLast();
				processed.add(curr);
				curr = dq.isEmpty() ? null : dq.getLast();
    		}
    	}
    }

    private static void print (Iterator<Node> it) {
    	if (it.hasNext()) System.out.print(it.next().data);
    	while (it.hasNext())
    		System.out.print(DELIM+(it.next().data));
    	System.out.println();
    }
}
