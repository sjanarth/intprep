package com.coreds.trees.core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public abstract class AbstractIterator<T> implements Iterator<BinaryTreeNode<T>> 
{
	protected AbstractIterator() {
		stack = new Stack<BinaryTreeNode<T>>();
		processed = new HashSet<BinaryTreeNode<T>>();
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	@Override
	public abstract BinaryTreeNode<T> next();
	
	protected BinaryTreeNode<T> popStack ()	{
		BinaryTreeNode<T> top = stack.pop();
		processed.add(top);
		return top;
	}
	
	protected void process (BinaryTreeNode<T> node) {
		processed.add(node);
	}
	
	protected boolean isProcessed (BinaryTreeNode<T> node) {
		return processed.contains(node);
	}

	protected void pushLeft (BinaryTreeNode<T> node)	{
		BinaryTreeNode<T> curr = node;
		while (curr != null) {
			stack.push(curr);
			curr = curr.getLeft();
		}
	}
	
	protected Stack<BinaryTreeNode<T>> stack = null;
	private Set<BinaryTreeNode<T>> processed = null;
}
