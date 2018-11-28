package com.intprep.trees.problems;

import java.util.HashMap;
import java.util.Map;

import com.intprep.trees.problems.BSTToLinkedList.Node;

public class LevelWithMostNodes 
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
		printLevelsAndCounts(root);
    }
	
    private static void addLevelsAndCounts (int level, Node node, Map<Integer,Integer> counts) {
    	if (node != null)	{
    		Integer count = counts.get(level);
    		if (count == null)	count = 1;
    		else count++;
    		counts.put(level, count);
    		addLevelsAndCounts(level+1, node.left, counts);
    		addLevelsAndCounts(level+1, node.right, counts);
    	}
    }
    
    private static void printLevelsAndCounts (Node root) {
    	Map<Integer, Integer> counts = new HashMap<Integer,Integer>();
    	if (root != null)	{
    		counts.put(1, 1);
			addLevelsAndCounts(2, root.left, counts);
			addLevelsAndCounts(2, root.right, counts);
    	}
    	Integer maxLevel = 0, maxCount = 0;
    	for (Integer level : counts.keySet())	{
    		Integer count = counts.get(level);
    		System.out.println("Level="+level+", count="+counts.get(level));
    		if (maxCount < count)	{
    			maxLevel = level;
    			maxCount = count;
    		}
    	}
    	System.out.println("Level with max nodes="+maxLevel+", count="+maxCount);
    }
}
