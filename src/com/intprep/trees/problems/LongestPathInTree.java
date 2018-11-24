package com.intprep.trees.problems;

import java.util.Stack;

import com.intprep.trees.BaseTreeNode;
import com.intprep.trees.BinaryTreeNode;

public class LongestPathInTree 
{
	private static class LongestPathInTreeTuple<T> {
		BinaryTreeNode<T> pathNode = null;
		int pathLen = -1;
		public LongestPathInTreeTuple(BinaryTreeNode<T> node, int len){
			pathNode = node;
			pathLen = len;
		}
	}
	
	private static LongestPathInTreeTuple<String> findLongestPath (BinaryTreeNode<String> node)	{
		LongestPathInTreeTuple<String> longestPath = new LongestPathInTreeTuple<String>(null, 0);
		if (node != null)	{
			if (node.isLeaf())	{
				return new LongestPathInTreeTuple<String>(node, 1);
			} else {
				for (BaseTreeNode<String> child : node.getChildren())	{
					LongestPathInTreeTuple<String> tuple = findLongestPath((BinaryTreeNode<String>)child);
					if (longestPath.pathLen <= tuple.pathLen)	{
						longestPath.pathNode = tuple.pathNode;
						longestPath.pathLen = tuple.pathLen+1;
					}
				}
			}
		}
		return longestPath;
	}
	
	private static void printPathInReverse (String s, BinaryTreeNode<String> node) {
		System.out.print(s+": ");
		Stack<BinaryTreeNode<String>> st = new Stack<BinaryTreeNode<String>>();
		while (node != null)	{
			st.push(node);
			node = (BinaryTreeNode<String>) node.getParent();
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop()+" ");
		}
		System.out.println();
	}
	
	private static BinaryTreeNode<String> buildSampleTree()	{
		BinaryTreeNode<String> root = new BinaryTreeNode<String>("a");
		BinaryTreeNode<String> left = new BinaryTreeNode<String>("b");
		left.setLeft(new BinaryTreeNode<String>("d"));
		left.setRight(new BinaryTreeNode<String>("e"));
		root.setLeft(left);
		BinaryTreeNode<String> right = new BinaryTreeNode<String>("c");
		BinaryTreeNode<String> f = new BinaryTreeNode<String>("f");
		right.setLeft(f);
		BinaryTreeNode<String> h = new BinaryTreeNode<String>("h");
		f.setLeft(h);
		h.setRight(new BinaryTreeNode<String>("i"));
		right.setRight(new BinaryTreeNode<String>("g"));
		root.setRight(right);
		
		return root;
	}
	
	public static void main (String[] args) {
		BinaryTreeNode<String> root = buildSampleTree();
		System.out.println("InOrder: "+root.getInOrderString());
		LongestPathInTreeTuple<String> maxPath = findLongestPath(root);
		System.out.println("MaxPath node: "+maxPath.pathNode);
		System.out.println("MaxPath length: "+maxPath.pathLen);
		printPathInReverse ("MaxPath path", maxPath.pathNode);
	}
}
