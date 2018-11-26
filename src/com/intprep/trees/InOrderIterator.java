package com.intprep.trees;

public class InOrderIterator<T> extends AbstractIterator<T>
{
	public InOrderIterator(BinaryTreeNode<T> node) {
		pushLeft(node);
	}
	
	@Override
	public BinaryTreeNode<T> next() {
		if (!hasNext())
			return null;
		BinaryTreeNode<T> top = popStack();
		pushLeft(top.getRight());
		return top;
	}
}
