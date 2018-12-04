package com.intprep.trees.core;

public class PreOrderIterator<T> extends AbstractIterator<T> 
{
	public PreOrderIterator(BinaryTreeNode<T> node) {
		if (node != null)	
			stack.push(node);
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = popStack();
		if (top.hasRight())
			stack.push(top.getRight());
		if (top.hasLeft())
			stack.push(top.getLeft());
		return top;
	}
}
