package com.intprep.trees;

import java.util.Iterator;
import java.util.Stack;

public abstract class AbstractIterator<T> implements Iterator<BinaryTreeNode<T>> 
{
	protected AbstractIterator() {
		stack = new Stack<BinaryTreeNode<T>>();
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	@Override
	public abstract BinaryTreeNode<T> next();

	protected void pushLeft (BinaryTreeNode<T> node)	{
		BinaryTreeNode<T> curr = node;
		while (curr != null) {
			stack.push(curr);
			curr = curr.getLeft();
		}
	}
	
	protected void pushRight (BinaryTreeNode<T> node)	{
		BinaryTreeNode<T> curr = node;
		while (curr != null) {
			stack.push(curr);
			curr = curr.getRight();
		}
	}

	protected Stack<BinaryTreeNode<T>> stack = null;
}
