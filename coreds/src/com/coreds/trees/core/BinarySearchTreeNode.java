package com.coreds.trees.core;

import java.util.Comparator;

public class BinarySearchTreeNode<T extends Comparator> extends BinaryTreeNode<T> 
{
	public BinarySearchTreeNode(T v) {
		super(v);
	}
	
	public BinarySearchTreeNode<T> getSuccessor()	{
		return null;
	}

	public BinarySearchTreeNode<T> getPredecessor()	{
		return null;
	}

	public BinarySearchTreeNode<T> getMin()	{
		return null;
	}

	public BinarySearchTreeNode<T> getMax()	{
		return null;
	}
}
